package com.weweibuy.brms.api.model.message;

import com.weweibuy.brms.api.model.dto.RuleExecReqDTO;
import lombok.Data;

/**
 * @author durenhao
 * @date 2020/12/4 20:41
 **/
@Data
public class RuleExecMessage extends RuleExecReqDTO {

    /**
     * 请求号 回执时用
     */
    private String reqNo;

    /**
     * 回调消息 tag
     */
    private String callBackTag;


}
