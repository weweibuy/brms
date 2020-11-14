package com.weweibuy.brms.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author durenhao
 * @date 2020/11/8 20:30
 **/
@Data
public class RuleExecReqDTO {

    @NotBlank
    private String ruleSetKey;

    private String agendaGroup;

    @NotNull
    @NotEmpty
    private Map model;

}
