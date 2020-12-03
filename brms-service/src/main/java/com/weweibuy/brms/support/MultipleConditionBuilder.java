package com.weweibuy.brms.support;

import com.weweibuy.brms.model.po.Model;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleCondition;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.drools.template.model.Condition;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/14 10:13
 **/
@Component
@RequiredArgsConstructor
public class MultipleConditionBuilder {

    private final List<ConditionBuilder> conditionBuilderList;

    private final ModelAndAttrRepository modelAndAttrRepository;

    public Condition buildCondition(Package rulePackage, List<RuleCondition> ruleConditionList, String modelKey) {
        Condition condition = new Condition();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> paramList = new ArrayList<>();
        ruleConditionList = ruleConditionList.stream()
                .sorted(Comparator.comparing(RuleCondition::getConditionOrder))
                .collect(Collectors.toList());
        for (int i = 0; i < ruleConditionList.size(); i++) {
            RuleCondition ruleCondition = ruleConditionList.get(i);
            // TODO 对象类型的支持
            String attrName = ruleCondition.getAttrName();
            ModelAttr modelAttr = null;
            boolean nesting = false;
            String[] attrArr = null;
            if (attrName.indexOf('.') != -1) {
                // 对象类型
                attrArr = attrName.split("\\.");
                if (attrArr.length == 1) {
                    throw Exceptions.business("对象类型属性错误");
                }

                modelAttr = lastModelAttr(attrArr, modelKey, 0);
                nesting = true;
            } else {
                modelAttr = modelAttr(attrName, modelKey);
            }
            ConditionBuildContext context = ConditionBuildContext.builder()
                    .maxIndex(ruleConditionList.size() - 1)
                    .conditionIndex(i)
                    .modelAttr(modelAttr)
                    .oriConditionAttrName(attrName)
                    .oriConditionAttrArr(attrArr)
                    .nesting(nesting)
                    .paramList(paramList)
                    .build();
            stringBuilder.append(matchAndBuild(rulePackage, ruleCondition, context));

            if (StringUtils.isNotBlank(ruleCondition.getLogicalOperator()) && i < ruleConditionList.size() - 1) {
                stringBuilder.append(" ")
                        .append(ruleCondition.getLogicalOperator())
                        .append(" ");
            }
        }
        String conditionStr = DrlBuildSupport.buildConditionStr(stringBuilder.toString(), paramList.stream().collect(Collectors.joining(",")));
        condition.setSnippet(conditionStr);
        return condition;
    }

    private String matchAndBuild(Package rulePackage, RuleCondition ruleCondition, ConditionBuildContext conditionBuildContext) {
        return conditionBuilderList.stream()
                .filter(c -> c.match(ruleCondition, conditionBuildContext.getModelAttr()))
                .findFirst()
                .map(c -> c.buildConditionStr(rulePackage, ruleCondition, conditionBuildContext))
                .orElseThrow(() -> Exceptions.business("无法匹配对应的规则构建器"));
    }

    public ModelAttr modelAttr(String attrName, String modelKey) {
        return modelAndAttrRepository.selectModelAttr(modelKey, attrName)
                .orElseThrow(() -> Exceptions.business(String.format("模型: %s, 属性 %s 不存在", modelKey, attrName)));
    }

    private ModelAttr lastModelAttr(String[] split, String modelKey, int index) {
        if (index == split.length - 1) {
            return modelAttr(split[index], modelKey);
        } else {
            ModelAttr modelAttr = modelAttr(split[index], modelKey);
            String attrModelKeyRef = modelAttr.getAttrModelKeyRef();
            String key = modelAndAttrRepository.selectModel(attrModelKeyRef)
                    .map(Model::getModelKey)
                    .orElseThrow(() -> Exceptions.business(String.format("模型: %s, 不存在", attrModelKeyRef)));
            return lastModelAttr(split, key, ++index);
        }

    }


}
