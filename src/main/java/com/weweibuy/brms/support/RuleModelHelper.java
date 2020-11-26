package com.weweibuy.brms.support;

import com.weweibuy.brms.manager.RuleQueryManager;
import com.weweibuy.brms.model.constant.RuleModelConstant;
import com.weweibuy.brms.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/25 21:00
 **/
@Component
@RequiredArgsConstructor
public class RuleModelHelper {

    private final RuleQueryManager ruleQueryManager;


    /**
     * 对不存在的属性赋空值
     *
     * @param inputModel
     * @param modelAttrList
     * @return
     */
    public void fixModel(Map<String, Object> inputModel, List<ModelAttr> modelAttrList) {
        Set<String> inputModelKeySet = inputModel.keySet();
        modelAttrList.stream()
                .map(ModelAttr::getAttrName)
                .filter(name -> !inputModelKeySet.contains(name))
                .forEach(name -> inputModel.put(name, null));
    }


    public Map<String, Object> newProcessModel(RuleExecReqDTO execReqDTO) {
        List<RuleExecReqDTO.RuleSetKeyReqDTO> ruleSet = execReqDTO.getRuleSet();
        List<String> ruleSetKeyList = ruleSet.stream()
                .map(RuleExecReqDTO.RuleSetKeyReqDTO::getRuleSetKey)
                .collect(Collectors.toList());

        List<Map<String, Object>> processRuleSetMap = ruleSetKeyList.stream()
                .map(rs -> {
                    Map<String, Object> ruleSetMap = new HashMap<>();
                    ruleSetMap.put(RuleModelConstant.PROCESS_RULE_SET_FILED_NAME, rs);
                    List<Rule> ruleList = ruleQueryManager.queryRule(rs);
                    List<Map<String, Object>> collect = ruleList.stream()
                            .map(rule -> {
                                Map<String, Object> ruleMap = new HashMap<>();
                                ruleMap.put(RuleModelConstant.PROCESS_RULE_NAME, rule.getRuleKey());
                                ruleMap.put(RuleModelConstant.PROCESS_RULE_HIT, false);
                                ruleMap.put(RuleModelConstant.PROCESS_RULE_AGENDA_GROUP, rule.getActivationGroup());
                                return ruleMap;
                            })
                            .collect(Collectors.toList());
                    ruleSetMap.put(RuleModelConstant.PROCESS_RULE_FILED_NAME, collect);
                    return ruleSetMap;
                })
                .collect(Collectors.toList());

        Map<String, Object> processModelMap = new HashMap<>();
        processModelMap.put("hit", false);
        processModelMap.put("process", processRuleSetMap);
        processModelMap.put("model", new HashMap<String, Object>());
        return processModelMap;

    }

}
