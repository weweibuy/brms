package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleActionMapper;
import com.weweibuy.brms.mapper.RuleConditionMapper;
import com.weweibuy.brms.model.example.RuleActionExample;
import com.weweibuy.brms.model.example.RuleConditionExample;
import com.weweibuy.brms.model.po.RuleAction;
import com.weweibuy.brms.model.po.RuleCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/11/8 21:44
 **/
@Repository
@RequiredArgsConstructor
public class ConditionAndActionRepository {

    private final RuleConditionMapper ruleConditionMapper;

    private final RuleActionMapper ruleActionMapper;


    public List<RuleCondition> selectRuleCondition(String ruleKey) {
        return ruleConditionMapper.selectByExample(RuleConditionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleKeyEqualTo(ruleKey)
                .example());
    }

    public List<RuleAction> selectRuleAction(String ruleKey) {
        return ruleActionMapper.selectByExample(RuleActionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleKeyEqualTo(ruleKey)
                .example());
    }


}
