package com.weweibuy.brms.api.model.dto;

import lombok.Data;

import java.util.List;

/**
 * 规则执行过程响应
 *
 * @author durenhao
 * @date 2020/11/27 20:50
 **/
@Data
public class RuleExecProcessRespDTO {

    private String ruleSet;

    private List<ProcessRuleDTO> rule;


    @Data
    public static class ProcessRuleDTO {

        private String name;

        private Boolean hit;

        private String agendaGroup;

    }



}
