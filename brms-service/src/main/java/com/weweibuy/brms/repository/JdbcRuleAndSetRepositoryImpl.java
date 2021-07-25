package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleMapper;
import com.weweibuy.brms.mapper.RuleSetMapper;
import com.weweibuy.brms.model.example.RuleExample;
import com.weweibuy.brms.model.example.RuleSetExample;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleSet;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/8 21:31
 **/
@Repository
@RequiredArgsConstructor
public class JdbcRuleAndSetRepositoryImpl implements RuleAndSetRepository {

    private final RuleMapper ruleMapper;

    private final RuleSetMapper ruleSetMapper;

    public Optional<RuleSet> selectRuleSet(String ruleSetKey) {
        return Optional.ofNullable(ruleSetMapper.selectOneByExample(RuleSetExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .example()));
    }


    public List<Rule> selectRule(String ruleSetKey) {
        return ruleMapper.selectByExample(RuleExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .when(StringUtils.isNotBlank(ruleSetKey),
                        c -> c.andRuleSetKeyEqualTo(ruleSetKey))
                .example());
    }

    public List<RuleSet> selectRuleSet(String ruleSetKey, String ruleSetName) {
        return ruleSetMapper.selectByExample(RuleSetExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .when(StringUtils.isNotBlank(ruleSetKey),
                        c -> c.andRuleSetKeyEqualTo(ruleSetKey))
                .when(StringUtils.isNotBlank(ruleSetName),
                        c -> c.andRuleSetNameLike("%" + ruleSetName + "%"))
                .example());
    }

}
