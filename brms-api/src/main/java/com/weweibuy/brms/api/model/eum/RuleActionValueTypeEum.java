package com.weweibuy.brms.api.model.eum;

import java.util.Arrays;
import java.util.Optional;

/**
 * 规则 action 值类型
 *
 * @author durenhao
 * @date 2020/11/30 22:27
 **/
public enum RuleActionValueTypeEum {

    /**
     * 输入型
     */
    INPUT,

    /**
     * 计算型
     */
    CALCULATE,
    ;

    public static Optional<RuleActionValueTypeEum> fromValue(String value) {
        return Arrays.stream(RuleActionValueTypeEum.values())
                .filter(a -> a.toString().equals(value))
                .findFirst();
    }


}
