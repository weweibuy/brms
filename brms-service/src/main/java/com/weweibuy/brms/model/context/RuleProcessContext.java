package com.weweibuy.brms.model.context;

import com.weweibuy.brms.api.model.dto.RuleExecProcessRespDTO;
import com.weweibuy.brms.api.model.dto.RuleExecRespDTO;
import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

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


        public RuleExecProcessRespDTO toRuleExecProcessRespDTO(){

            RuleExecProcessRespDTO ruleExecProcessRespDTO = new RuleExecProcessRespDTO();
            ruleExecProcessRespDTO.setRuleSet(ruleSet);

            List<RuleExecProcessRespDTO.ProcessRuleDTO> collect = processRuleMap.values().stream()
                    .sorted(Comparator.comparing(ProcessRule::getSalience).reversed())
                    .map(ProcessRule::toProcessRuleDTO)
                    .collect(Collectors.toList());
            ruleExecProcessRespDTO.setRule(collect);
            return ruleExecProcessRespDTO;

        }

    }

    @Data
    public static class ProcessRule {

        private String name;

        private Boolean hit;

        private String agendaGroup;

        private Integer salience;


        public RuleExecProcessRespDTO.ProcessRuleDTO toProcessRuleDTO() {
            return BeanCopyUtils.copy(this, RuleExecProcessRespDTO.ProcessRuleDTO.class);
        }


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



    public RuleExecRespDTO toRuleExecRespDTO(Map<String, Object> resultModel){

        resultModel.remove(RuleBuildConstant.RULE_HIT_FLAG_NAME);

        RuleExecRespDTO ruleExecRespDTO = new RuleExecRespDTO();
        ruleExecRespDTO.setHit(hit);
        ruleExecRespDTO.setModel(resultModel);

        List<RuleExecProcessRespDTO> collect = processRuleSetMap.values().stream()
                .map(ProcessRuleSet::toRuleExecProcessRespDTO)
                .collect(Collectors.toList());
        ruleExecRespDTO.setProcess(collect);
        return ruleExecRespDTO;

    }


}
