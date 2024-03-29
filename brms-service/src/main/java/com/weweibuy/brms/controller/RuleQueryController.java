package com.weweibuy.brms.controller;

import com.weweibuy.brms.api.model.dto.req.RuleHitLogReqDTO;
import com.weweibuy.brms.api.model.dto.resp.*;
import com.weweibuy.brms.service.RuleQueryService;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.dto.CommonPageRequest;
import com.weweibuy.framework.common.core.model.dto.CommonPageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 规则查询接口
 *
 * @author durenhao
 * @date 2021/7/23 21:36
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/rule/query")
public class RuleQueryController {

    private final RuleQueryService ruleQueryService;

    @GetMapping("/rule-set/list")
    public CommonDataResponse<CommonPageResult<RuleSetRespDTO>> ruleSet(String ruleSetKey, String ruleSetName,
                                                                        CommonPageRequest pageRequest) {
        return CommonDataResponse.success(ruleQueryService.ruleSet(ruleSetKey, ruleSetName, pageRequest));
    }

    @GetMapping("/rule-set")
    public CommonDataResponse<RuleSetRespDTO> ruleSet(@RequestParam String ruleSetKey) {
        return CommonDataResponse.success(ruleQueryService.ruleSet(ruleSetKey));
    }

    @GetMapping("/rule")
    public CommonDataResponse<RuleRespDTO> rule(@RequestParam String ruleKey) {
        return CommonDataResponse.success(ruleQueryService.rule(ruleKey));
    }

    @GetMapping("/rule/list")
    public CommonDataResponse<CommonPageResult<RuleRespDTO>> ruleList(String ruleSetKey, CommonPageRequest pageRequest) {
        return CommonDataResponse.success(ruleQueryService.ruleList(ruleSetKey, pageRequest));
    }

    @GetMapping("/rule-set/model")
    public CommonDataResponse<List<RuleSetModelRespDTO>> ruleSetModel(@RequestParam String ruleSetKey) {
        return CommonDataResponse.success(ruleQueryService.ruleSetModel(ruleSetKey));
    }

    @GetMapping("/model")
    public CommonDataResponse<ModelRespDTO> model(@RequestParam String modelKey) {
        return CommonDataResponse.success(ruleQueryService.model(modelKey));
    }

    @GetMapping("/model/attr")
    public CommonDataResponse<List<RuleModelAttrRespDTO>> ruleSetModelAttr(@RequestParam String modelKey) {
        return CommonDataResponse.success(ruleQueryService.ruleSetModelAttr(modelKey));
    }


    @GetMapping("/rule/condition")
    public CommonDataResponse<List<RuleConditionRespDTO>> ruleCondition(@RequestParam String ruleKey) {
        return CommonDataResponse.success(ruleQueryService.ruleCondition(ruleKey));
    }

    @GetMapping("/rule/action")
    public CommonDataResponse<List<RuleActionRespDTO>> ruleAction(@RequestParam String ruleKey) {
        return CommonDataResponse.success(ruleQueryService.ruleAction(ruleKey));
    }

    @GetMapping("/rule/hit-log/list")
    public CommonDataResponse<CommonPageResult<RuleHitLogRespDTO>> ruleHitLog(RuleHitLogReqDTO query) {
        return CommonDataResponse.success(ruleQueryService.ruleHitLog(query));
    }

    /**
     * 翻译规则
     *
     * @param ruleKey
     * @return
     */
    @GetMapping("/rule/translate")
    public CommonDataResponse<RuleTranslateRespDTO> ruleTranslate(@RequestParam String ruleKey) {
        return CommonDataResponse.success(ruleQueryService.ruleTranslate(ruleKey));
    }

}
