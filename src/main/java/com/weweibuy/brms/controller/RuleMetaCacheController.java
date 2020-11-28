package com.weweibuy.brms.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
