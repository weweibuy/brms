package com.weweibuy.brms.support;

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
        for (int i = 0; i < ruleConditionList.size(); i++) {
            RuleCondition ruleCondition = ruleConditionList.get(i);
            ModelAttr modelAttr = modelAttr(ruleCondition, modelKey);
            stringBuilder.append(matchAndBuild(rulePackage, ruleCondition, modelAttr, paramList, i));
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

    private String matchAndBuild(Package rulePackage, RuleCondition ruleCondition, ModelAttr modelAttr, List<String> paramList, Integer index) {
        return conditionBuilderList.stream()
                .filter(c -> c.match(ruleCondition, modelAttr))
                .findFirst()
                .map(c -> c.buildConditionStr(rulePackage, ruleCondition, modelAttr, paramList, index))
                .orElseThrow(() -> Exceptions.business("无法匹配对应的规则构建器"));
    }

    public ModelAttr modelAttr(RuleCondition ruleCondition, String modelKey) {
        String attrName = ruleCondition.getAttrName();
        return modelAndAttrRepository.selectModelAttr(modelKey, attrName)
                .orElseThrow(() -> Exceptions.business(String.format("模型: %s, 属性 %s 不存在", modelKey, attrName)));
    }


}
