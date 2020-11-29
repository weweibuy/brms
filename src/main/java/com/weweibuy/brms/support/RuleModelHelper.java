package com.weweibuy.brms.support;

import com.weweibuy.brms.manager.RuleQueryManager;
import com.weweibuy.brms.model.context.RuleProcessContext;
import com.weweibuy.brms.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/25 21:00
 **/
@Component
@RequiredArgsConstructor
public class RuleModelHelper {

    private final RuleQueryManager ruleQueryManager;

    private final ModelAndAttrRepository modelAndAttrRepository;


    /**
     * 对不存在的属性赋空值
     *
     * @param inputModel
     * @param modelAttrList
     * @return
     */
    public void fixModel(Map<String, Object> inputModel, List<ModelAttr> modelAttrList) {
        modelAttrList.stream()
                .forEach(modelAttr -> {
                    String attrName = modelAttr.getAttrName();
                    Object nestModelObject = inputModel.get(attrName);
                    if (nestModelObject == null) {
                        inputModel.put(attrName, null);
                    } else if (ModelAttrTypeEum.OBJECT.toString().equals(modelAttr.getAttrType())) {
                        if (!(nestModelObject instanceof Map)) {
                            throw Exceptions.business(String.format("输入模型: %s, 错误", modelAttr.getModelKey()));
                        }
                        Map<String, Object> nestModelMap = (Map<String, Object>) nestModelObject;
                        String attrModelKeyRef = modelAttr.getAttrModelKeyRef();
                        List<ModelAttr> modelAttrs = modelAndAttrRepository.selectModelAttrByModelKey(attrModelKeyRef);
                        fixModel(nestModelMap, modelAttrs);
                    }
                });
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
