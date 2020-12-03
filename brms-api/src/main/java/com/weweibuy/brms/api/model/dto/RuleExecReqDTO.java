package com.weweibuy.brms.api.model.dto;

import com.weweibuy.brms.api.model.eum.MultipleRuleSetExecModelStrategyEum;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 执行规则请求
 *
 * @author durenhao
 * @date 2020/11/8 20:30
 **/
@Data
public class RuleExecReqDTO {

    @Valid
    @NotEmpty(message = "规则信息不能为空")
    private List<RuleSetKeyReqDTO> ruleSet;

    /**
     * 请求模型
     */
    @NotEmpty(message = "请求模型不能为空集合")
    private Map<String, Object> model;

    /**
     * 模型策略模式  模式 USE_ACTION_MODEL
     */
    private MultipleRuleSetExecModelStrategyEum modelStrategy;

    @Data
    public static class RuleSetKeyReqDTO {

        /**
         * 规则集
         */
        @NotBlank(message = "ruleSetKey 不能为空")
        private String ruleSetKey;

        /**
         * 规则名称
         */
        private Set<String> ruleNameList;

        /**
         * 议程组
         */
        private String agendaGroup;

    }


}
