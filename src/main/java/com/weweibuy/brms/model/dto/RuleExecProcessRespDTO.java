package com.weweibuy.brms.model.dto;

import com.weweibuy.brms.model.context.RuleProcessContext;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 规则执行过程响应
 *
 * @author durenhao
 * @date 2020/11/27 20:50
 **/
@Data
public class RuleExecProcessRespDTO {

    private String ruleSet;

    private List<RuleExecProcessRespDTO.ProcessRuleDTO> rule;


    @Data
    public static class ProcessRuleDTO {

        private String name;

        private Boolean hit;

        private String agendaGroup;

    }


    public static RuleExecProcessRespDTO fromProcessRuleSet(RuleProcessContext.ProcessRuleSet processRuleSet) {
        RuleExecProcessRespDTO ruleExecProcessRespDTO = new RuleExecProcessRespDTO();
        ruleExecProcessRespDTO.setRuleSet(processRuleSet.getRuleSet());

        List<ProcessRuleDTO> collect = processRuleSet.getProcessRuleMap().values().stream()
                .sorted(Comparator.comparing(RuleProcessContext.ProcessRule::getSalience).reversed())
                .map(RuleExecProcessRespDTO::fromProcessRule)
                .collect(Collectors.toList());
        ruleExecProcessRespDTO.setRule(collect);
        return ruleExecProcessRespDTO;
    }


    public static ProcessRuleDTO fromProcessRule(RuleProcessContext.ProcessRule processRule) {
        return BeanCopyUtils.copy(processRule, ProcessRuleDTO.class);
    }

}
