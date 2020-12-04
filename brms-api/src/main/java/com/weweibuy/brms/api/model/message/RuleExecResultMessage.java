package com.weweibuy.brms.api.model.message;

import com.weweibuy.brms.api.model.dto.RuleExecRespDTO;
import lombok.Data;

/**
 * @author durenhao
 * @date 2020/12/4 22:26
 **/
@Data
public class RuleExecResultMessage extends RuleExecRespDTO {

    /**
     * 请求号
     */
    private String reqNo;

}
