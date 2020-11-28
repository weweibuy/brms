package com.weweibuy.brms.repository.cache;

import com.weweibuy.brms.model.po.Rule;
import com.weweibuy.brms.model.po.RuleSet;
import com.weweibuy.brms.repository.RuleAndSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/25 21:40
 **/
@Component
@RequiredArgsConstructor
@Primary
@CacheConfig(cacheNames = "rule_and_set_cache", keyGenerator = "classMethodParamNameCacheKeyGenerator")
public class CacheRuleAndSetRepositoryImpl implements RuleAndSetRepository {

    private final RuleAndSetRepository delegate;

    @Override
    @Cacheable
    public Optional<RuleSet> selectRuleSet(String ruleSetKey) {
        return delegate.selectRuleSet(ruleSetKey);
    }

    @Override
    @Cacheable
    public List<Rule> selectRule(String ruleSetKey) {
        return delegate.selectRule(ruleSetKey);
    }
}
