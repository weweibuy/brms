package com.weweibuy.brms.support;

import com.weweibuy.brms.manager.RuleQueryManager;
import com.weweibuy.brms.model.context.RuleProcessContext;
import com.weweibuy.brms.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    public void bingProcessContext(RuleExecReqDTO execReqDTO) {
        RuleProcessContext ruleProcessContext = newProcessContext(execReqDTO);
        RuleProcessContextHolder.putContext(ruleProcessContext);
    }


    /**
     * @param execReqDTO
     * @return
     */
    public RuleProcessContext newProcessContext(RuleExecReqDTO execReqDTO) {

        List<RuleExecReqDTO.RuleSetKeyReqDTO> ruleSet = execReqDTO.getRuleSet();
        List<String> ruleSetKeyList = ruleSet.stream()
                .map(RuleExecReqDTO.RuleSetKeyReqDTO::getRuleSetKey)
                .collect(Collectors.toList());

        List<RuleProcessContext.ProcessRuleSet> processRuleSetList = ruleSetKeyList.stream()
                .map(rs -> {
                    List<Rule> ruleList = ruleQueryManager.queryRule(rs);
                    List<RuleProcessContext.ProcessRule> processRuleList = ruleList.stream()
                            .map(rule -> RuleProcessContext.processRule(rule, false))
                            .collect(Collectors.toList());
                    return RuleProcessContext.processRuleSet(rs, processRuleList);
                })
                .collect(Collectors.toList());

        return RuleProcessContext.ruleProcessContext(false, processRuleSetList);

    }

}
