package com.weweibuy.brms.controller;

import com.weweibuy.brms.service.RuleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/11/9 21:45
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/rule/query")
public class RuleQueryController {

    private final RuleQueryService ruleQueryService;

    @GetMapping("/compile")
    public String compile(String ruleSetKey) {
        return ruleQueryService.compile(ruleSetKey);
    }

}
