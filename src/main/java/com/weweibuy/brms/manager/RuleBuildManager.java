package com.weweibuy.brms.manager;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleAction;
import com.weweibuy.brms.model.po.RuleCondition;
import com.weweibuy.brms.model.po.RuleSet;
import com.weweibuy.brms.repository.ConditionAndActionRepository;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.brms.repository.RuleAndSetRepository;
import com.weweibuy.brms.repository.RuleSetModelRepository;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.drools.decisiontable.parser.LhsBuilder;
import org.drools.template.model.*;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.List;

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

        List<Rule> ruleList = ruleAndSetRepository.selectRule(ruleSetKey);
        ruleList.stream()
                .map(this::buildDRule)
                .forEach(rulePackage::addRule);
        Import anImport = new Import();
        anImport.setClassName(RuleBuildConstant.MAP_CLAZZ);
        rulePackage.addImport(anImport);
        DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        return out.getDRL();
    }


    public org.drools.template.model.Rule buildDRule(Rule rule) {
        List<RuleCondition> ruleConditionList = conditionAndActionRepository.selectRuleCondition(rule.getRuleKey());
        List<RuleAction> ruleActionList = conditionAndActionRepository.selectRuleAction(rule.getRuleKey());

        org.drools.template.model.Rule dRule = new org.drools.template.model.Rule(
                rule.getRuleKey(), null, rule.getId().intValue());
        ruleConditionList.stream()
                .map(this::buildCondition)
                .forEach(dRule::addCondition);
        ruleActionList.stream()
                .map(this::buildRuleAction)
                .forEach(dRule::addConsequence);
        return dRule;
    }

    public Condition buildCondition(RuleCondition ruleCondition) {
        Condition condition = new Condition();
        String format = String.format("%s %s %s", ruleCondition.getAttrKey(), ruleCondition.getConditionOperator(), "$1");

        LhsBuilder lhsBuilder = new LhsBuilder(0, 0, RuleBuildConstant.CONDITION_MODEL);

        lhsBuilder.addTemplate(0, 0, format);
        lhsBuilder.addCellValue(0, 0, ruleCondition.getConditionValue());
        condition.setSnippet(lhsBuilder.getResult());
        return condition;
    }

    public Consequence buildRuleAction(RuleAction ruleAction) {
        Consequence consequence = new Consequence();
        consequence.setSnippet("xxx");
        return consequence;
    }

}
