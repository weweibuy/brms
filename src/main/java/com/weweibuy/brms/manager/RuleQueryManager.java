package com.weweibuy.brms.manager;

import com.weweibuy.brms.model.eum.ModelTypeEum;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleSetModel;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.brms.repository.RuleAndSetRepository;
import com.weweibuy.brms.repository.RuleSetModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 规则查询管理
 *
 * @author durenhao
 * @date 2020/11/25 20:38
 **/
@Component
@RequiredArgsConstructor
public class RuleQueryManager {

    private final RuleSetModelRepository ruleSetModelRepository;

    private final ModelAndAttrRepository modelAndAttrRepository;

    private final RuleAndSetRepository ruleAndSetRepository;


    /**
     * 查询 ruleSetKey 模型属性
     *
     * @param ruleSetKey
     * @param modelTypeEum
     * @return
     */
    public Optional<List<ModelAttr>> queryModelAttr(String ruleSetKey, ModelTypeEum modelTypeEum) {
        return ruleSetModelRepository.selectRuleSetModel(ruleSetKey, modelTypeEum)
                .map(RuleSetModel::getModelKey)
                .map(modelAndAttrRepository::selectModelAttrByModelKey);
    }



    /**
     * 查询规则
     *
     * @param ruleSetKey
     * @return
     */
    public List<Rule> queryRule(String ruleSetKey) {
        return ruleAndSetRepository.selectRule(ruleSetKey);
    }


}
