package com.weweibuy.brms.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author durenhao
 * @date 2020/11/21 21:18
 **/
@Data
public class BaseRuleActionReqDTO {

    @NotBlank(message = "namespace 不能为空")
    private String namespace;

    @NotBlank(message = "ruleSetKey 不能为空")
    private String ruleSetKey;
}
