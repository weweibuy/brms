package com.weweibuy.brms.support;

import com.weweibuy.brms.model.context.RuleProcessContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/27 20:41
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RuleProcessContextHolder {

    private static final ThreadLocal<RuleProcessContext> CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    public static void putContext(RuleProcessContext context) {
        CONTEXT_THREAD_LOCAL.set(context);
    }


    public static Optional<RuleProcessContext> getContext() {
        return Optional.ofNullable(CONTEXT_THREAD_LOCAL.get());
    }

    public static void clearContext() {
        CONTEXT_THREAD_LOCAL.remove();
    }


}
