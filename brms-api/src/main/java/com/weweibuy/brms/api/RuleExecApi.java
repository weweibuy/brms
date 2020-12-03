package com.weweibuy.brms.api;

import com.weweibuy.brms.api.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.api.model.dto.RuleExecRespDTO;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author durenhao
 * @date 2020/12/3 22:16
 **/
@RequestMapping("/rule")
public interface RuleExecApi {

    @PostMapping("/exec")
     CommonDataResponse<RuleExecRespDTO> execRule(@RequestBody @Valid RuleExecReqDTO reqDTO);

}
