package com.weweibuy.brms.repository;

import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleSet;

import java.util.List;
import java.util.Optional;

/**
 * 规则集 与规则仓库
 *
 * @author durenhao
 * @date 2020/11/25 21:38
 **/
public interface RuleAndSetRepository {

    /**
     * 查询规则集
     *
     * @param ruleSetKey
     * @return
     */
    Optional<RuleSet> selectRuleSet(String ruleSetKey);

    /**
     * 查询规则
     *
     * @param ruleSetKey
     * @return
     */
    List<Rule> selectRule(String ruleSetKey);

}
