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


    public String compile(String namespace, String ruleSetKey) {
        return ruleBuildManager.buildNamespaceRules(namespace, ruleSetKey);
    }

    public void reload(String namespace, String ruleSetKey) {
        kieBaseHolder.removePackage(namespace, ruleSetKey);
        kieBaseHolder.addPackage(namespace, ruleSetKey);
    }

    public void remove(String namespace, String ruleSetKey) {
        kieBaseHolder.removePackage(namespace, ruleSetKey);
    }
}
