package com.weweibuy.brms.service;

import com.github.pagehelper.Page;
import com.weweibuy.brms.api.model.constant.RuleBuildConstant;
import com.weweibuy.brms.api.model.dto.req.RuleHitLogReqDTO;
import com.weweibuy.brms.api.model.dto.resp.*;
import com.weweibuy.brms.api.model.eum.ModelTypeEum;
import com.weweibuy.brms.api.model.eum.RuleActionValueTypeEum;
import com.weweibuy.brms.model.example.RuleHitLogExample;
import com.weweibuy.brms.model.po.*;
import com.weweibuy.brms.repository.*;
import com.weweibuy.brms.support.RuleTranslateHelper;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.model.dto.CommonPageRequest;
import com.weweibuy.framework.common.core.model.dto.CommonPageResult;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.framework.common.db.utils.PageHelperUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
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

    private final RuleTranslateHelper ruleTranslateHelper;

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

    public RuleTranslateRespDTO ruleTranslate(String ruleKey) {
        Rule rule = ruleAndSetRepository.selectRuleByRuleKey(ruleKey)
                .orElseThrow(() -> Exceptions.business("规则不存在"));
        List<RuleSetModel> modelList = ruleSetModelRepository.selectRuleSetModel(rule.getRuleSetKey());
        RuleSetModel inputModel = modelList.stream()
                .filter(r -> ModelTypeEum.INPUT.toString().equals(r.getModelType()))
                .findFirst()
                .orElse(null);


        RuleSetModel outputModel = modelList.stream()
                .filter(r -> ModelTypeEum.OUTPUT.toString().equals(r.getModelType()))
                .findFirst()
                .orElse(null);

        RuleTranslateRespDTO ruleTranslateRespDTO = new RuleTranslateRespDTO();

        if (inputModel != null) {
            Map<String, String> stringStringMap = ruleTranslateHelper.translateAttr(inputModel, RuleBuildConstant.MODEL_ATTR_SEPARATOR);

            List<RuleCondition> ruleConditionList = conditionAndActionRepository.selectRuleCondition(ruleKey);
            if (CollectionUtils.isNotEmpty(ruleConditionList)) {
                List<String> collect = ruleConditionList.stream()
                        .map(c -> {
                            String desc = stringStringMap.get(c.getAttrName());
                            return desc + " " + c.getConditionOperator() + " " + c.getConditionValue();
                        })
                        .collect(Collectors.toList());
                ruleTranslateRespDTO.setCondition(collect);
            }
        }

        if (outputModel != null) {
            Map<String, String> stringStringMap = ruleTranslateHelper.translateAttr(outputModel, ".");

            Map<String, String> inputMap = Optional.ofNullable(inputModel)
                    .map(i -> ruleTranslateHelper.translateAttr(i, RuleBuildConstant.FORMULA_ATTR_SEPARATOR))
                    .orElse(Collections.emptyMap());

            List<RuleAction> ruleActionList = conditionAndActionRepository.selectRuleAction(ruleKey);
            if (CollectionUtils.isNotEmpty(ruleActionList)) {
                List<String> collect = ruleActionList.stream()
                        .map(a ->
                                RuleActionValueTypeEum.fromValue(a.getActionValueType())
                                        .map(t -> actionDesc(t, a, stringStringMap.get(a.getAttrName()), inputMap))
                                        .orElse(""))
                        .collect(Collectors.toList());
                ruleTranslateRespDTO.setAction(collect);
            }
        }

        return ruleTranslateRespDTO;
    }


    private String actionDesc(RuleActionValueTypeEum actionValueType, RuleAction ruleAction,
                              String attrDesc, Map<String, String> inputMap) {
        switch (actionValueType) {
            case INPUT:
                return attrDesc + " = " + ruleAction.getActionValue();
            case CALCULATE:
                String anElse = Optional.ofNullable(ruleAction.getValueCalculateFormula())
                        .map(s -> Arrays.stream(s.split(" "))
                                .map(String::trim)
                                .map(i -> Optional.ofNullable(inputMap.get(i)).orElse(i))
                                .collect(Collectors.joining(" ")))
                        .orElse("");
                return attrDesc + " = " + anElse;
            default:
                return "";
        }
    }

    public RuleRespDTO rule(String ruleKey) {
        return ruleAndSetRepository.selectRuleByRuleKey(ruleKey)
                .map(r -> BeanCopyUtils.copy(r, RuleRespDTO.class))
                .orElse(null);

    }

    public ModelRespDTO model(String modelKey) {
        return modelAndAttrRepository.selectModel(modelKey)
                .map(m -> BeanCopyUtils.copy(m, ModelRespDTO.class))
                .orElse(null);
    }

}
