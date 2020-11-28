package com.weweibuy.brms.model.context;

import com.weweibuy.brms.model.po.Rule;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/27 20:21
 **/
@Data
public class RuleProcessContext {

    private Boolean hit;

    private Map<String, ProcessRuleSet> processRuleSetMap;


    @Data
    public static class ProcessRuleSet {

        private String ruleSet;

        private Map<String, ProcessRule> processRuleMap;

    }

    @Data
    public static class ProcessRule {

        private String name;

        private Boolean hit;

        private String agendaGroup;

        private Integer salience;

    }

    public static ProcessRule processRule(Rule rule, Boolean hit) {
        ProcessRule processRule = new ProcessRule();
        processRule.setName(rule.getRuleKey());
        processRule.setHit(hit);
        processRule.setAgendaGroup(rule.getAgendaGroup());
        processRule.setSalience(Optional.ofNullable(rule.getSalience()).orElse(0));
        return processRule;
    }

    public static ProcessRuleSet processRuleSet(String ruleSetKey, List<ProcessRule> ruleList) {
        ProcessRuleSet processRuleSet = new ProcessRuleSet();
        processRuleSet.setRuleSet(ruleSetKey);
        Map<String, ProcessRule> ruleLinkedHashMap = new LinkedHashMap<>();
        ruleList.forEach(r -> ruleLinkedHashMap.put(r.getName(), r));
        processRuleSet.setProcessRuleMap(ruleLinkedHashMap);
        return processRuleSet;
    }

    public static RuleProcessContext ruleProcessContext(Boolean hit, List<ProcessRuleSet> ruleSetList) {
        RuleProcessContext ruleProcessContext = new RuleProcessContext();
        ruleProcessContext.setHit(hit);
        Map<String, ProcessRuleSet> ruleSetLinkedHashMap = new LinkedHashMap<>();
        ruleSetList.forEach(r -> ruleSetLinkedHashMap.put(r.getRuleSet(), r));
        ruleProcessContext.setProcessRuleSetMap(ruleSetLinkedHashMap);
        return ruleProcessContext;
    }


}
