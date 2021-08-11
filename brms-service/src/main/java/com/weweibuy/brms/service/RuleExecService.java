package com.weweibuy.brms.service;

import com.weweibuy.brms.api.model.constant.RuleBuildConstant;
import com.weweibuy.brms.api.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.api.model.dto.RuleExecRespDTO;
import com.weweibuy.brms.api.model.eum.ModelTypeEum;
import com.weweibuy.brms.api.model.eum.MultipleRuleSetExecModelStrategyEum;
import com.weweibuy.brms.drools.RuleLogEventListener;
import com.weweibuy.brms.manager.RuleQueryManager;
import com.weweibuy.brms.model.context.RuleProcessContext;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.support.KieBaseHolder;
import com.weweibuy.brms.support.RuleModelHelper;
import com.weweibuy.brms.support.RuleProcessContextHolder;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private final RuleQueryManager ruleQueryManager;

    private final RuleModelHelper ruleModelHelper;

    /**
     * 执行规则
     *
     * @param reqDTO
     * @return
     */
    public Map<String, Object> doExecRule(RuleExecReqDTO reqDTO) {
        List<RuleExecReqDTO.RuleSetKeyReqDTO> ruleSet = reqDTO.getRuleSet();
        MultipleRuleSetExecModelStrategyEum modelStrategy = reqDTO.getModelStrategy();

        Map<String, Object> resultMap = reqDTO.getModel();
        for (RuleExecReqDTO.RuleSetKeyReqDTO ruleSetKeyReqDTO : ruleSet) {
            List<ModelAttr> modelAttrList = ruleQueryManager.queryModelAttr(ruleSetKeyReqDTO.getRuleSetKey(), ModelTypeEum.INPUT)
                    .orElseThrow(() -> Exceptions.business("规则模型不存在"));
            // fix 属性
            ruleModelHelper.fixModel(resultMap, modelAttrList);
            // 执行规则
            resultMap = doExecRule(ruleSetKeyReqDTO.getRuleSetKey(), ruleSetKeyReqDTO.getRuleNameList(),
                    ruleSetKeyReqDTO.getAgendaGroup(), resultMap);
            if (!(Boolean) resultMap.get(RuleBuildConstant.RULE_HIT_FLAG_NAME)) {
                break;
            }
        }
        return resultMap;
    }


    /**
     * 执行规则
     *
     * @param reqDTO
     * @return
     */
    public RuleExecRespDTO execRule(RuleExecReqDTO reqDTO) {
        RuleProcessContext ruleProcessContext = ruleModelHelper.newProcessContext(reqDTO);
        RuleProcessContextHolder.putContext(ruleProcessContext);
        try {
            Map<String, Object> execRule = doExecRule(reqDTO);
            // ruleProcessContext
            return ruleProcessContext.toRuleExecRespDTO(execRule);
        } finally {
            RuleProcessContextHolder.clearContext();
        }
    }


    /**
     * 执行规则
     *
     * @param ruleSetKey
     * @param ruleNameList
     * @param agendaGroup
     * @param model
     * @return
     */
    public Map<String, Object> doExecRule(String ruleSetKey, Set<String> ruleNameList, String agendaGroup,
                                          Map<String, Object> model) {
        KieBase kieBase = kieBaseHolder.findKieBase(ruleSetKey);
        KieSession kieSession = kieBase.newKieSession();
        try {
            kieSession.addEventListener(ruleLogEventListener);
            Map<String, Object> result = new HashMap<>();
            result.put(RuleBuildConstant.RULE_HIT_FLAG_NAME, false);
            kieSession.setGlobal(RuleBuildConstant.RESULT_MODEL, result);
            if (StringUtils.isNotBlank(agendaGroup)) {
                kieSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
            }
            kieSession.insert(model);
            if (CollectionUtils.isNotEmpty(ruleNameList)) {
                kieSession.fireAllRules(match -> ruleNameList.contains(match.getRule().getName()));
            } else {
                kieSession.fireAllRules();
            }
            return result;
        } finally {
            kieSession.dispose();
        }
    }

}
