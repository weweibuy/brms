package com.weweibuy.brms.repository.cache;

import com.weweibuy.brms.model.eum.ModelTypeEum;
import com.weweibuy.brms.model.po.RuleSetModel;
import com.weweibuy.brms.repository.RuleSetModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/25 20:52
 **/
@Component
@Primary
@RequiredArgsConstructor
public class CacheRuleSetModelRepositoryImpl implements RuleSetModelRepository {

    private final RuleSetModelRepository delegate;

    @Override
    public List<RuleSetModel> selectRuleSetModel(String ruleSetKey) {
        return delegate.selectRuleSetModel(ruleSetKey);
    }

    @Override
    public Optional<RuleSetModel> selectRuleSetModel(String ruleSetKey, ModelTypeEum modelType) {
        return delegate.selectRuleSetModel(ruleSetKey, modelType);
    }
}
