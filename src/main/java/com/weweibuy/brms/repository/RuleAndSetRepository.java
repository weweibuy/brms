package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleMapper;
import com.weweibuy.brms.mapper.RuleNamespaceMapper;
import com.weweibuy.brms.mapper.RuleSetMapper;
import com.weweibuy.brms.model.example.RuleExample;
import com.weweibuy.brms.model.example.RuleNamespaceExample;
import com.weweibuy.brms.model.example.RuleSetExample;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleNamespace;
import com.weweibuy.brms.model.po.RuleSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/8 21:31
 **/
@Repository
@RequiredArgsConstructor
public class RuleAndSetRepository {

    private final RuleMapper ruleMapper;

    private final RuleSetMapper ruleSetMapper;

    private final RuleNamespaceMapper ruleNamespaceMapper;

    public List<RuleNamespace> selectNamespace(String namespace) {
        return ruleNamespaceMapper.selectByExample(RuleNamespaceExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andNamespaceDescEqualTo(namespace)
                .example());
    }

    public List<RuleSet> selectRuleSet(String namespace) {
        return ruleSetMapper.selectByExample(RuleSetExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andNamespaceEqualTo(namespace)
                .example());
    }

    public Optional<RuleSet> selectRuleSet(String namespace, String ruleSetKey) {
        return Optional.ofNullable(ruleSetMapper.selectOneByExample(RuleSetExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andNamespaceEqualTo(namespace)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .example()));
    }


    public List<Rule> selectRule(String ruleSetKey) {
        return ruleMapper.selectByExample(RuleExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .example());
    }

}
