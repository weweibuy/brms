package com.weweibuy.brms.controller;

import com.weweibuy.brms.service.RuleManageService;
import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 规则管理接口
 *
 * @author durenhao
 * @date 2020/11/9 21:45
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/rule/manage")
public class RuleMangeController {

    private final RuleManageService ruleManageService;

    @GetMapping("/compile")
    public String compile(String ruleSetKey) {
        return ruleManageService.compile(ruleSetKey);
    }

    @PostMapping("/reload")
    public CommonCodeResponse reload(String ruleSetKey) {
        ruleManageService.reload(ruleSetKey);
        return CommonCodeResponse.success();
    }

}
