package com.weweibuy.brms.controller;

import com.weweibuy.brms.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.model.dto.RuleExecRespDTO;
import com.weweibuy.brms.service.RuleExecService;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 规则执行接口
 *
 * @author durenhao
 * @date 2020/11/8 20:28
 **/
@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleExecController {

    private final RuleExecService ruleExecService;

    @PostMapping("/exec")
    public CommonDataResponse<RuleExecRespDTO> execRule(@RequestBody @Valid RuleExecReqDTO reqDTO) {
        return CommonDataResponse.success(ruleExecService.execRule(reqDTO));
    }


}
