package com.weweibuy.brms.config;

import lombok.ToString;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author durenhao
 * @date 2020/11/28 11:44
 **/
@ToString
public class CacheSimpleKey implements Serializable {

    private final Class clazz;

    private final Method method;

    private final Object[] params;

    // Effectively final, just re-calculated on deserialization
    private transient int hashCode;


    public CacheSimpleKey(Class clazz, Method method, Object[] elements) {
        this.clazz = clazz;
        this.method = method;
        if (elements == null || elements.length == 0) {
            this.params = null;
            Object[] objects = new Object[]{clazz, method};
            this.hashCode = Arrays.deepHashCode(objects);
        } else {
            this.params = elements.clone();
            Object[] objects = new Object[params.length + 2];
            System.arraycopy(params, 0, objects, 0, params.length);
            objects[params.length] = this.clazz;
            objects[params.length + 1] = this.method;
            // Pre-calculate hashCode field
            this.hashCode = Arrays.deepHashCode(objects);
        }
    }

    @Override
    public boolean equals(@Nullable Object other) {
        return (this == other ||
                (other instanceof CacheSimpleKey &&
                        ((CacheSimpleKey) other).clazz.equals(clazz)
                        && ((CacheSimpleKey) other).method.equals(method) &&
                        Arrays.deepEquals(this.params, ((CacheSimpleKey) other).params)));
    }

    @Override
    public final int hashCode() {
        // Expose pre-calculated hashCode field
        return this.hashCode;
    }

}
