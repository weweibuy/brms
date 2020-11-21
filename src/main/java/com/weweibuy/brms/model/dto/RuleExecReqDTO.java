package com.weweibuy.brms.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    /**
     * 名称空间
     */
    @NotBlank(message = "namespace 不能为空")
    private String namespace;

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

    /**
     * 请求模型
     */
    @NotEmpty(message = "请求模型 不能为空集合")
    private Map<String, Object> model;

}
