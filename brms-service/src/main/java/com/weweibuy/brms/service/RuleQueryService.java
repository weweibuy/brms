package com.weweibuy.brms.service;

import com.github.pagehelper.Page;
import com.weweibuy.brms.api.model.dto.resp.*;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleAction;
import com.weweibuy.brms.model.po.RuleCondition;
import com.weweibuy.brms.model.po.RuleSetModel;
import com.weweibuy.brms.repository.ConditionAndActionRepository;
import com.weweibuy.brms.repository.JdbcRuleAndSetRepositoryImpl;
import com.weweibuy.brms.repository.JdbcRuleSetModelRepositoryImpl;
import com.weweibuy.framework.common.core.model.dto.CommonPageRequest;
import com.weweibuy.framework.common.core.model.dto.CommonPageResult;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.framework.common.db.utils.PageHelperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2021/7/23 21:47
 **/
@Service
@RequiredArgsConstructor
public class RuleQueryService {

    private final JdbcRuleAndSetRepositoryImpl ruleAndSetRepository;

    private final JdbcRuleSetModelRepositoryImpl ruleSetModelRepository;

    private final ConditionAndActionRepository conditionAndActionRepository;

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
}
