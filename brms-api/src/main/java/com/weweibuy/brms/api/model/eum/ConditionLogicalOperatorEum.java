package com.weweibuy.brms.api.model.eum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

/**
 * 条件逻辑操作符
 *
 * @author durenhao
 * @date 2021/8/8 9:35
 **/
@Getter
@RequiredArgsConstructor
public enum ConditionLogicalOperatorEum {


    AND("&&", "并且"),

    OR("||", "或者"),
    ;


    private final String code;

    private final String desc;


    public static Optional<ConditionLogicalOperatorEum> fromCode(String code) {
        return Arrays.stream(ConditionLogicalOperatorEum.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst();
    }

}
