package com.weweibuy.brms.api;

import com.weweibuy.brms.api.model.dto.req.RuleHitLogReqDTO;
import com.weweibuy.brms.api.model.dto.resp.*;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.dto.CommonPageRequest;
import com.weweibuy.framework.common.core.model.dto.CommonPageResult;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author durenhao
 * @date 2021/7/25 17:00
 **/
public interface RuleQueryApi {

    @GetMapping("/rule/query/rule-set/list")
    CommonDataResponse<CommonPageResult<RuleSetRespDTO>> ruleSet(@RequestParam("ruleSetKey") String ruleSetKey, @RequestParam("ruleSetName") String ruleSetName,
                                                                 @SpringQueryMap CommonPageRequest pageRequest);

    @GetMapping("/rule/query/rule-set")
    CommonDataResponse<RuleSetRespDTO> ruleSet(@RequestParam("ruleSetKey") String ruleSetKey);

    @GetMapping("/rule/query/rule/list")
    CommonDataResponse<CommonPageResult<RuleRespDTO>> ruleList(@RequestParam("ruleSetKey") String ruleSetKey, @SpringQueryMap CommonPageRequest pageRequest);

    @GetMapping("/rule/query/rule-set/model")
    CommonDataResponse<List<RuleSetModelRespDTO>> ruleSetModel(@RequestParam("ruleSetKey") String ruleSetKey);

    @GetMapping("/rule/query/model/attr")
    CommonDataResponse<List<RuleModelAttrRespDTO>> ruleSetModelAttr(@RequestParam("modelKey") String modelKey);

    @GetMapping("/rule/query/rule/condition")
    CommonDataResponse<List<RuleConditionRespDTO>> ruleCondition(@RequestParam("ruleKey") String ruleKey);

    @GetMapping("/rule/query/rule/action")
    CommonDataResponse<List<RuleActionRespDTO>> ruleAction(@RequestParam("ruleKey") String ruleKey);

    @GetMapping("/rule/query/rule/hit-log/list")
    CommonDataResponse<CommonPageResult<RuleHitLogRespDTO>> ruleHitLog(@SpringQueryMap RuleHitLogReqDTO query);

    @GetMapping("/rule/query/rule")
    CommonDataResponse<RuleRespDTO> rule(@RequestParam("ruleKey") String ruleKey);

    @GetMapping("/rule/query/model")
    CommonDataResponse<ModelRespDTO> model(@RequestParam("modelKey") String modelKey);

}
