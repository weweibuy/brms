package com.weweibuy.brms.repository;

import com.weweibuy.brms.model.eum.ModelTypeEum;
import com.weweibuy.brms.model.po.RuleSetModel;

import java.util.List;
import java.util.Optional;

/**
 * 规则集模型
 *
 * @author durenhao
 * @date 2020/11/25 20:40
 **/
public interface RuleSetModelRepository {

    /**
     * 查询模型
     *
     * @param ruleSetKey
     * @return
     */
    List<RuleSetModel> selectRuleSetModel(String ruleSetKey);

    /**
     * 查询模型
     *
     * @param ruleSetKey
     * @param modelType
     * @return
     */
    Optional<RuleSetModel> selectRuleSetModel(String ruleSetKey, ModelTypeEum modelType);

}
