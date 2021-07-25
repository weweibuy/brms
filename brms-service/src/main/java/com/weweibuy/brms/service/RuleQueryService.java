package com.weweibuy.brms.service;

import com.github.pagehelper.Page;
import com.weweibuy.brms.api.model.dto.req.RuleHitLogReqDTO;
import com.weweibuy.brms.api.model.dto.resp.*;
import com.weweibuy.brms.model.example.RuleHitLogExample;
import com.weweibuy.brms.model.po.*;
import com.weweibuy.brms.repository.*;
import com.weweibuy.framework.common.core.model.dto.CommonPageRequest;
import com.weweibuy.framework.common.core.model.dto.CommonPageResult;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.framework.common.db.utils.PageHelperUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 规则查询服务
 *
 * @author durenhao
 * @date 2021/7/23 21:47
 **/
@Service
@RequiredArgsConstructor
public class RuleQueryService {

    private final JdbcRuleAndSetRepositoryImpl ruleAndSetRepository;

    private final JdbcRuleSetModelRepositoryImpl ruleSetModelRepository;

    private final ConditionAndActionRepository conditionAndActionRepository;

    private final RuleHitLogRepository ruleHitLogRepository;

    private final JdbcModelAndAttrRepositoryImpl modelAndAttrRepository;

    public CommonPageResult<RuleSetRespDTO> ruleSet(String ruleSetKey, String ruleSetName, CommonPageRequest pageRequest) {
        Page<Object> objectPage = PageHelperUtils.startPage(pageRequest);
        List<RuleSetRespDTO> dtoList = ruleAndSetRepository.selectRuleSet(ruleSetKey, ruleSetName)
                .stream()
                .map(r -> BeanCopyUtils.copy(r, RuleSetRespDTO.class))
                .collect(Collectors.toList());
        return CommonPageResult.withTotalAndList(objectPage.getTotal(), dtoList);
    }

    public RuleSetRespDTO ruleSet(String ruleSetKey) {
        return ruleAndSetRepository.selectRuleSet(ruleSetKey)
                .map(r -> BeanCopyUtils.copy(r, RuleSetRespDTO.class))
                .orElse(null);
    }

    public CommonPageResult<RuleRespDTO> ruleList(String ruleSetKey, CommonPageRequest pageRequest) {
        Page<Object> objectPage = PageHelperUtils.startPage(pageRequest);
        List<Rule> ruleList = ruleAndSetRepository.selectRule(ruleSetKey);
        List<RuleRespDTO> ruleRespDTOS = BeanCopyUtils.copyCollection(ruleList, Rule.class, RuleRespDTO.class);
        return CommonPageResult.withTotalAndList(objectPage.getTotal(), ruleRespDTOS);
    }

    public List<RuleSetModelRespDTO> ruleSetModel(String ruleSetKey) {
        List<RuleSetModel> ruleSetModelList = ruleSetModelRepository.selectRuleSetModel(ruleSetKey);
        return BeanCopyUtils.copyCollection(ruleSetModelList, RuleSetModel.class, RuleSetModelRespDTO.class);
    }

    public List<RuleConditionRespDTO> ruleCondition(String ruleKey) {
        List<RuleCondition> ruleConditionList = conditionAndActionRepository.selectRuleCondition(ruleKey);
        return BeanCopyUtils.copyCollection(ruleConditionList, RuleCondition.class, RuleConditionRespDTO.class);
    }

    public List<RuleActionRespDTO> ruleAction(String ruleKey) {
        List<RuleAction> ruleConditionList = conditionAndActionRepository.selectRuleAction(ruleKey);
        return BeanCopyUtils.copyCollection(ruleConditionList, RuleAction.class, RuleActionRespDTO.class);

    }

    public CommonPageResult<RuleHitLogRespDTO> ruleHitLog(RuleHitLogReqDTO query) {
        Page<Object> page = PageHelperUtils.startPage(query);
        List<RuleHitLog> logList = ruleHitLogRepository.select(toRuleHitLogExample(query));
        List<RuleHitLogRespDTO> dtoList = BeanCopyUtils.copyCollection(logList, RuleHitLog.class, RuleHitLogRespDTO.class);
        return CommonPageResult.withTotalAndList(page.getTotal(), dtoList);
    }

    private RuleHitLogExample toRuleHitLogExample(RuleHitLogReqDTO query) {
        return Optional.ofNullable(query)
                .map(q -> RuleHitLogExample.newAndCreateCriteria()
                        .andDeletedEqualTo(false)
                        .when(StringUtils.isNotBlank(q.getRuleSetKey()), c -> c.andRuleSetKeyEqualTo(q.getRuleSetKey()))
                        .when(StringUtils.isNotBlank(q.getRuleKey()), c -> c.andRuleKeyEqualTo(q.getRuleKey()))
                        .when(StringUtils.isNotBlank(q.getRequestNo()), c -> c.andRequestNoEqualTo(q.getRequestNo()))
                        .when(StringUtils.isNotBlank(q.getAgendaGroup()), c -> c.andAgendaGroupEqualTo(q.getAgendaGroup()))
                        .when(Objects.nonNull(q.getCreateTimeFrom()), c -> c.andCreateTimeGreaterThanOrEqualTo(q.getCreateTimeFrom()))
                        .when(Objects.nonNull(q.getCreateTimeTo()), c -> c.andCreateTimeLessThanOrEqualTo(q.getCreateTimeTo()))
                        .example())
                .orElse(null);
    }

    public List<RuleModelAttrRespDTO> ruleSetModelAttr(String modelKey) {
        List<ModelAttr> modelAttrList = modelAndAttrRepository.selectModelAttrByModelKey(modelKey);
        return BeanCopyUtils.copyCollection(modelAttrList, ModelAttr.class, RuleModelAttrRespDTO.class);
    }
}
