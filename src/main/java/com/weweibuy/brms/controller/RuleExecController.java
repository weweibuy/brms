package com.weweibuy.brms.controller;

import com.weweibuy.brms.model.dto.RuleExecReqDTO;
import com.weweibuy.brms.service.RuleExecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * 规则执行接口
 *
 * @author durenhao
 * @date 2020/11/8 20:28
 **/
@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleExecController {

    private final RuleExecService ruleExecService;

    @PostMapping("/exec")
    public Map<String, Object> execRule(@RequestBody @Valid RuleExecReqDTO reqDTO) {
        return ruleExecService.execRule(reqDTO.getRuleSetKey(), reqDTO.getRuleNameList(), reqDTO.getAgendaGroup(), reqDTO.getModel());
    }


}
