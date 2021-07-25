package com.weweibuy.brms.repository.cache;

import com.weweibuy.brms.api.model.eum.ModelTypeEum;
import com.weweibuy.brms.model.po.RuleSetModel;
import com.weweibuy.brms.repository.RuleSetModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/25 20:52
 **/
@Slf4j
@Component
@Primary
@RequiredArgsConstructor
@CacheConfig(cacheNames = "rule_set_model_cache", keyGenerator = "classMethodParamNameCacheKeyGenerator")
public class CacheRuleSetModelRepositoryImpl implements RuleSetModelRepository {

    private final RuleSetModelRepository delegate;

    @Override
    @Cacheable
    public List<RuleSetModel> selectRuleSetModel(String ruleSetKey) {
        return delegate.selectRuleSetModel(ruleSetKey);
    }

    @Override
    @Cacheable
    public Optional<RuleSetModel> selectRuleSetModel(String ruleSetKey, ModelTypeEum modelType) {
        return delegate.selectRuleSetModel(ruleSetKey, modelType);
    }

    @CacheEvict(allEntries = true)
    public void evict() {
        log.warn("刷新: {} 全部缓存成功 ", "rule_set_model_cache");
    }

}
