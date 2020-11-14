package com.weweibuy.brms.manager;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.*;
import com.weweibuy.brms.repository.ConditionAndActionRepository;
import com.weweibuy.brms.repository.RuleAndSetRepository;
import com.weweibuy.brms.repository.RuleSetModelRepository;
import com.weweibuy.brms.support.ActionBuilder;
import com.weweibuy.brms.support.MultipleConditionBuilder;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.drools.template.model.*;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author durenhao
 * @date 2020/11/8 21:19
 **/
@Component
@RequiredArgsConstructor
public class RuleBuildManager {

    private final ConditionAndActionRepository conditionAndActionRepository;

    private final RuleAndSetRepository ruleAndSetRepository;

    private final RuleSetModelRepository ruleSetModelRepository;

    private final MultipleConditionBuilder multipleConditionBuilder;

    private final ActionBuilder actionBuilder;


    /**
     * @param ruleSetKey
     * @return
     */
    public String buildRuleStr(String ruleSetKey) {
        RuleSet ruleSet = ruleAndSetRepository.selectRuleSet(ruleSetKey)
                .orElseThrow(() -> Exceptions.business(String.format("规则集: %s不存在", ruleSetKey)));

        RuleSetModel ruleSetModel = ruleSetModelRepository.selectRuleSetModel(ruleSetKey)
                .orElseThrow(() -> Exceptions.business(String.format("规则集: %s对应的模型不存在", ruleSetKey)));
        String modelKey = ruleSetModel.getModelKey();

        Package rulePackage = new Package(ruleSetKey);

        Import anImport = new Import();
        anImport.setClassName(RuleBuildConstant.MAP_CLAZZ);
        rulePackage.addImport(anImport);

        Global global = new Global();
        global.setClassName(RuleBuildConstant.MAP_CLAZZ);
        global.setIdentifier(RuleBuildConstant.RESULT_MODEL);
        rulePackage.addVariable(global);

        ruleAndSetRepository.selectRule(ruleSetKey).stream()
                .map(rule -> buildDRule(rulePackage, rule, modelKey))
                .forEach(rulePackage::addRule);

        DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        return out.getDRL();
    }


    public org.drools.template.model.Rule buildDRule(Package rulePackage, Rule rule, String modelKey) {
        List<RuleCondition> ruleConditionList = conditionAndActionRepository.selectRuleCondition(rule.getRuleKey());
        List<RuleAction> ruleActionList = conditionAndActionRepository.selectRuleAction(rule.getRuleKey());

        org.drools.template.model.Rule dRule = new org.drools.template.model.Rule(
                rule.getRuleKey(), null, rule.getId().intValue());

        ruleProperties(rule, dRule);

        if (CollectionUtils.isNotEmpty(ruleConditionList)) {
            Condition condition = buildCondition(rulePackage, ruleConditionList, modelKey);
            dRule.addCondition(condition);
        }

        ruleActionList.stream()
                .map(r -> buildRuleAction(rulePackage, r))
                .forEach(dRule::addConsequence);
        return dRule;
    }

    public Condition buildCondition(Package rulePackage, List<RuleCondition> ruleConditionList, String modelKey) {
        return multipleConditionBuilder.buildCondition(rulePackage, ruleConditionList, modelKey);
    }

    public Consequence buildRuleAction(Package rulePackage, RuleAction ruleAction) {
        return actionBuilder.buildRuleAction(rulePackage, ruleAction);
    }

    private void ruleProperties(Rule rule, org.drools.template.model.Rule dRule) {
        if (StringUtils.isNotBlank(rule.getAgendaGroup())) {
            dRule.setAgendaGroup(rule.getAgendaGroup());
        }
        if (StringUtils.isNotBlank(rule.getActivationGroup())) {
            dRule.setActivationGroup(rule.getActivationGroup());
        }
        if (StringUtils.isNotBlank(rule.getNoLoop())) {
            dRule.setNoLoop(Boolean.valueOf(rule.getNoLoop()));
        }
        if (Objects.nonNull(rule.getSalience())) {
            dRule.setSalience(rule.getSalience());
        }
        if (StringUtils.isNotBlank(rule.getDateEffective())) {
            dRule.setDateEffective(rule.getDateEffective());
        }
        if (StringUtils.isNotBlank(rule.getDateExpires())) {
            dRule.setDateExpires(rule.getDateExpires());
        }
    }

}
