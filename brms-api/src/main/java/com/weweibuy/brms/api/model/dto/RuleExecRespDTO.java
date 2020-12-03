package com.weweibuy.brms.api.model.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 规则执行响应
 *
 * @author durenhao
 * @date 2020/11/27 20:49
 **/
@Data
public class RuleExecRespDTO {

    private Boolean hit;

    private Map<String, Object> model;

    private List<RuleExecProcessRespDTO> process;


}
