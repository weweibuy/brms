package com.weweibuy.brms.api;

import com.weweibuy.brms.api.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.api.model.dto.RuleExecRespDTO;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author durenhao
 * @date 2020/12/3 22:16
 **/
@RequestMapping("/rule")
public interface RuleExecApi {

    /**
     * 执行规则
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/exec")
    CommonDataResponse<RuleExecRespDTO> execRule(RuleExecReqDTO reqDTO);

}
