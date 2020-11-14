package com.weweibuy.brms.service;

import com.weweibuy.brms.drools.RuleLogEventListener;
import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.support.KieBaseHolder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    private final KieBaseHolder kieBaseHolder;

    private final RuleLogEventListener ruleLogEventListener;

    /**
     * 执行规则
     *
     * @param ruleSetKey
     * @param agendaGroup
     * @param model
     * @return
     */
    public Map execRule(String ruleSetKey, String agendaGroup, Map model) {
        KieBase kieBase = kieBaseHolder.findKieBase(ruleSetKey);
        KieSession kieSession = kieBase.newKieSession();
        kieSession.addEventListener(ruleLogEventListener);
        Map<Object, Object> result = new HashMap<>();
        kieSession.setGlobal(RuleBuildConstant.RESULT_MODEL, result);
        if (StringUtils.isNotBlank(agendaGroup)) {
            kieSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
        }
        kieSession.insert(model);
        kieSession.fireAllRules();
        return result;
    }

}
