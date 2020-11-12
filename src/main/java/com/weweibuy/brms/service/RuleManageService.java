package com.weweibuy.brms.service;

import com.weweibuy.brms.manager.RuleBuildManager;
import com.weweibuy.brms.support.KieBaseHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2020/11/9 21:47
 **/
@Service
@RequiredArgsConstructor
public class RuleManageService {

    private final RuleBuildManager ruleBuildManager;

    private final KieBaseHolder kieBaseHolder;


    public String compile(String ruleSetKey) {
        return ruleBuildManager.buildRuleStr(ruleSetKey);
    }

    public void reload(String ruleSetKey) {
        kieBaseHolder.remove(ruleSetKey);
        kieBaseHolder.findKieBase(ruleSetKey);
    }
}
