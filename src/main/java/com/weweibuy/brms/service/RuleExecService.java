package com.weweibuy.brms.service;

import com.weweibuy.brms.manager.RuleBuildManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 规则执行服务
 *
 * @author durenhao
 * @date 2020/11/8 20:45
 **/
@Service
@RequiredArgsConstructor
public class RuleExecService {

    private final RuleBuildManager ruleBuildManager;

    /**
     * 执行规则
     *
     * @param ruleSetKey
     * @param model
     * @return
     */
    public Map execRule(String ruleSetKey, Map model) {
        return null;
    }

}