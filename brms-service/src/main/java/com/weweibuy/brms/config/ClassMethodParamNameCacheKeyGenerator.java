package com.weweibuy.brms.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * key 生成器
 *
 * @author durenhao
 * @date 2020/11/28 11:24
 **/

public class ClassMethodParamNameCacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return generateKey(target, method, params);
    }

    public static Object generateKey(Object target, Method method, Object... params) {
        if (params.length == 0) {
            String simpleName = target.getClass().getSimpleName();
            String name = method.getName();
            return new CacheSimpleKey(target.getClass(), method, null);
        }
        return new CacheSimpleKey(target.getClass(), method, params);
    }

}
