package com.weweibuy.brms.support;

import com.weweibuy.brms.manager.RuleQueryManager;
import com.weweibuy.brms.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.model.po.ModelAttr;
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
    public static void fixModel(Map<String, Object> inputModel, List<ModelAttr> modelAttrList) {
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

//        ruleSetKeyList.stream()
//                .map(ruleQueryManager::queryRule)
//                .map(rules -> rules.stream().collect(Collectors.groupingBy(Rule::getRuleSetKey, Collectors.mapping())))
//
//
//        Map<String, Object> processModelMap = new HashMap<>();
        return null;

    }

}
