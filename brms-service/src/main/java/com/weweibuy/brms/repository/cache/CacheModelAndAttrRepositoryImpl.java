package com.weweibuy.brms.repository.cache;

import com.weweibuy.brms.model.po.Model;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
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
 * @date 2020/11/25 20:50
 **/
@Slf4j
@Component
@Primary
@RequiredArgsConstructor
@CacheConfig(cacheNames = "model_and_attr_cache", keyGenerator = "classMethodParamNameCacheKeyGenerator")
public class CacheModelAndAttrRepositoryImpl implements ModelAndAttrRepository {

    private final ModelAndAttrRepository delegate;

    @Override
    public Optional<Model> selectModel(String modelKey) {
        return delegate.selectModel(modelKey);
    }

    @Override
    @Cacheable
    public List<ModelAttr> selectModelAttrByModelKey(String modelKey) {
        return delegate.selectModelAttrByModelKey(modelKey);
    }

    @Override
    @Cacheable
    public Optional<ModelAttr> selectModelAttr(String modelKey, String attrName) {
        return delegate.selectModelAttr(modelKey, attrName);
    }

    @CacheEvict(allEntries = true)
    public void evict() {
        log.warn("刷新: {} 全部缓存成功 ", "model_and_attr_cache");
    }


}
