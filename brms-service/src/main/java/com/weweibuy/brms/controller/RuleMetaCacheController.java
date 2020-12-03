package com.weweibuy.brms.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 规则元数据缓存
 *
 * @author durenhao
 * @date 2020/11/28 10:02
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/rule/meta/cache")
public class RuleMetaCacheController {

    private final CacheManager ruleMetaCache;

    @GetMapping
    public CommonDataResponse<Map<String, List<String>>> listCacheKey() {
        Collection<String> cacheNames = ruleMetaCache.getCacheNames();
        Map<String, List<String>> cacheKeyMap = new HashMap<>();
        for (String name : cacheNames) {
            Cache<Object, Object> nativeCache = (Cache<Object, Object>) ruleMetaCache.getCache(name).getNativeCache();
            List<String> keyList = nativeCache.asMap().keySet().stream().map(Object::toString).collect(Collectors.toList());
            cacheKeyMap.put(name, keyList);
        }
        return CommonDataResponse.success(cacheKeyMap);
    }


    @DeleteMapping
    public CommonCodeResponse evictCacheKey() {
        Collection<String> cacheNames = ruleMetaCache.getCacheNames();
        cacheNames.stream()
                .map(name -> (Cache<Object, Object>) ruleMetaCache.getCache(name).getNativeCache())
                .forEach(cache -> cache.invalidateAll());
        return CommonDataResponse.success();
    }

    @DeleteMapping("/{name}")
    public CommonCodeResponse evictCacheKey(@PathVariable String name) {
        Collection<String> cacheNames = ruleMetaCache.getCacheNames();
        if (!cacheNames.contains(name)) {
            throw Exceptions.business("缓存: " + name + "不存在");
        }

        Cache<Object, Object> cache = (Cache<Object, Object>) ruleMetaCache.getCache(name).getNativeCache();
        cache.invalidateAll();
        return CommonDataResponse.success();
    }


}
