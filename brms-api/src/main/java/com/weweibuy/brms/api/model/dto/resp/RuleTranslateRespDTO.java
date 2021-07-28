package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * 规则翻译响应
 * @author durenhao
 * @date 2021/7/27 21:22
 **/
@Data
public class RuleTranslateRespDTO {

    private List<String> condition;

    private List<String> action;


}
