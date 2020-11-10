package com.weweibuy.brms.manager;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.model.po.*;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.repository.ConditionAndActionRepository;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.brms.repository.RuleAndSetRepository;
import com.weweibuy.brms.repository.RuleSetModelRepository;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.drools.decisiontable.parser.ActionType;
import org.drools.decisiontable.parser.LhsBuilder;
import org.drools.decisiontable.parser.RhsBuilder;
import org.drools.template.model.*;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/8 21:19
 **/
@Component
@RequiredArgsConstructor
public class RuleBuildManager {

    private final ConditionAndActionRepository conditionAndActionRepository;

    private final ModelAndAttrRepository modelAndAttrRepository;

    private final RuleAndSetRepository ruleAndSetRepository;

    private final RuleSetModelRepository ruleSetModelRepository;


    /**
     * @param ruleSetKey
     * @return
     */
    public String buildRuleStr(String ruleSetKey) {
        RuleSet ruleSet = ruleAndSetRepository.selectRuleSet(ruleSetKey)
                .orElseThrow(() -> Exceptions.business(String.format("规则集: %s不存在", ruleSetKey)));

        Package rulePackage = new Package(ruleSetKey);

        Import anImport = new Import();
        anImport.setClassName(RuleBuildConstant.MAP_CLAZZ);
        rulePackage.addImport(anImport);

        Global global = new Global();
        global.setClassName(RuleBuildConstant.MAP_CLAZZ);
        global.setIdentifier(RuleBuildConstant.RESULT_MODEL);
        rulePackage.addVariable(global);

        ruleAndSetRepository.selectRule(ruleSetKey).stream()
                .map(this::buildDRule)
                .forEach(rulePackage::addRule);

        DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        return out.getDRL();
    }


    public org.drools.template.model.Rule buildDRule(Rule rule) {
        List<RuleCondition> ruleConditionList = conditionAndActionRepository.selectRuleCondition(rule.getRuleKey());
        List<RuleAction> ruleActionList = conditionAndActionRepository.selectRuleAction(rule.getRuleKey());

        org.drools.template.model.Rule dRule = new org.drools.template.model.Rule(
                rule.getRuleKey(), null, rule.getId().intValue());
        if (CollectionUtils.isNotEmpty(ruleConditionList)) {
            Condition condition = buildCondition(ruleConditionList);
            dRule.addCondition(condition);
        }

        ruleActionList.stream()
                .map(this::buildRuleAction)
                .forEach(dRule::addConsequence);
        return dRule;
    }

    public Condition buildCondition(List<RuleCondition> ruleConditionList) {
        if (ruleConditionList.size() == 1) {
            RuleCondition ruleCondition = ruleConditionList.get(0);
            return buildCondition(ruleCondition);
        }

        List<String> paramList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ruleConditionList.size(); i++) {
            RuleCondition ruleCondition = ruleConditionList.get(i);
            stringBuilder.append(ruleCondition.getAttrKey())
                    .append(" ")
                    .append(ruleCondition.getConditionOperator())
                    .append(" ")
                    .append("$")
                    .append(i + 1);
            if (StringUtils.isNotBlank(ruleCondition.getLogicalOperator())) {
                stringBuilder.append(" ")
                        .append(ruleCondition.getLogicalOperator())
                        .append(" ");
            }
            paramList.add(paramStr(ruleCondition.getAttrKey(), ruleCondition.getConditionValue()));
        }
        return buildCondition(stringBuilder.toString(), paramList.stream().collect(Collectors.joining(",")));
    }

    private Condition buildCondition(String template, String param) {
        LhsBuilder lhsBuilder = new LhsBuilder(0, 0, RuleBuildConstant.CONDITION_MODEL);
        Condition condition = new Condition();
        lhsBuilder.addTemplate(0, 0, template);
        lhsBuilder.addCellValue(0, 0, param);
        condition.setSnippet(lhsBuilder.getResult());
        return condition;
    }

    public Condition buildCondition(RuleCondition ruleCondition) {
        String template = String.format("%s %s %s", ruleCondition.getAttrKey(), ruleCondition.getConditionOperator(), "$1");
        String conditionValueStr = paramStr(ruleCondition.getAttrKey(), ruleCondition.getConditionValue());
        return buildCondition(template, conditionValueStr);
    }

    private String paramStr(String attrKey, String attrValue) {
        ModelAttr modelAttr = modelAndAttrRepository.selectModelAttr(attrKey)
                .orElseThrow(() -> Exceptions.business("属性key " + attrKey + "不存在"));
        String attrType = modelAttr.getAttrType();

        ModelAttrTypeEum modelAttrTypeEum = ModelAttrTypeEum.valueOf(attrType);
        String conditionValueStr = "";
        switch (modelAttrTypeEum) {
            case NUMBER:
                conditionValueStr = attrValue;
                break;
            case STRING:
                conditionValueStr = "\"" + attrValue + "\"";
                break;
            case DATE:
                conditionValueStr = DateTimeUtils.localDateTimeToTimestampMilli(DateTimeUtils.stringToLocalDateTime(attrValue)) + "";
                break;
            case BOOLEAN:
                conditionValueStr = attrValue;
                break;
            case COLLECTION:
                conditionValueStr = "[" + attrValue + "]";
                break;
            default:
        }
        return conditionValueStr;
    }

    public Consequence buildRuleAction(RuleAction ruleAction) {
        RhsBuilder rhsBuilder = new RhsBuilder(ActionType.Code.ACTION, 0, 0, null);
        Consequence consequence = new Consequence();
        String attrKey = ruleAction.getAttrKey();
        String resultModelPut = RuleBuildConstant.RESULT_MODEL_PUT;
        rhsBuilder.addTemplate(0, 0, resultModelPut);
        String paramStr = paramStr(attrKey, ruleAction.getActionValue());
        rhsBuilder.addCellValue(0, 0, "\"" + attrKey + "\"," + paramStr);
        consequence.setSnippet(rhsBuilder.getResult());
        return consequence;
    }


}
