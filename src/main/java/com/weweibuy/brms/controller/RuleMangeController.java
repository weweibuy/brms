package com.weweibuy.brms.controller;

import com.weweibuy.brms.model.dto.BaseRuleActionReqDTO;
import com.weweibuy.brms.service.RuleManageService;
import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author durenhao
 * @date 2020/11/9 21:45
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/rule/manage")
public class RuleMangeController {

    private final RuleManageService ruleManageService;

    @GetMapping("/compile")
    public String compile(String namespace, String ruleSetKey) {
        return ruleManageService.compile(namespace, ruleSetKey);
    }

    @PostMapping("/reload")
    public CommonCodeResponse reload(@RequestBody @Valid BaseRuleActionReqDTO actionReqDTO) {
        ruleManageService.reload(actionReqDTO.getNamespace(), actionReqDTO.getRuleSetKey());
        return CommonCodeResponse.success();
    }

    @PostMapping("/remove")
    public CommonCodeResponse remove(@RequestBody @Valid BaseRuleActionReqDTO actionReqDTO) {
        ruleManageService.remove(actionReqDTO.getNamespace(), actionReqDTO.getRuleSetKey());
        return CommonCodeResponse.success();
    }


}
