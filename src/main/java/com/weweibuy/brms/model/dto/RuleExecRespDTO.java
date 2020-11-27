package com.weweibuy.brms.model.dto;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.context.RuleProcessContext;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 规则执行响应
 *
 * @author durenhao
 * @date 2020/11/27 20:49
 **/
@Data
public class RuleExecRespDTO {

    private Boolean hit;

    private Map<String, Object> model;

    private List<RuleExecProcessRespDTO> process;


    public static RuleExecRespDTO fromProcessContext(RuleProcessContext context, Map<String, Object> resultModel) {
        resultModel.remove(RuleBuildConstant.RULE_HIT_FLAG_NAME);

        RuleExecRespDTO ruleExecRespDTO = new RuleExecRespDTO();
        ruleExecRespDTO.setHit(context.getHit());
        ruleExecRespDTO.setModel(resultModel);

        List<RuleExecProcessRespDTO> collect = context.getProcessRuleSetMap().values().stream()
                .map(RuleExecProcessRespDTO::fromProcessRuleSet)
                .collect(Collectors.toList());
        ruleExecRespDTO.setProcess(collect);
        return ruleExecRespDTO;
    }

}
