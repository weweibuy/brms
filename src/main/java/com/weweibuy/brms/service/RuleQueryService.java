package com.weweibuy.brms.service;

import com.weweibuy.brms.manager.RuleBuildManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2020/11/9 21:47
 **/
@Service
@RequiredArgsConstructor
public class RuleQueryService {

    private final RuleBuildManager ruleBuildManager;


    public String compile(String ruleSetKey) {
        return ruleBuildManager.buildRuleStr(ruleSetKey);
    }
}
