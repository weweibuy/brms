package com.weweibuy.brms.api.model.eum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 条件操作符
 *
 * @author durenhao
 * @date 2020/11/12 21:48
 **/
@Getter
@RequiredArgsConstructor
public enum OperatorEum {

    GREATER_THAN(">", "大于"),

    GREATER_THAN_or_equal(">=", "大于等于"),

    LESS_THAN("<", "小于"),

    LESS_THAN_OR_EQUAL("<=", "小于等于"),

    EQUAL_TO("==", "等于"),

    NOT_EQUAL_TO("!=", "不等于"),

    MEMBER_OF("memberOf", "memberOf"),

    ALL_MEMBER_OF("all memberOf", "all memberOf"),

    NOT_MEMBER_OF("not memberOf", "not memberOf"),

    NOT_ALL_MEMBER_OF("not all memberOf", "not all memberOf"),

    CONTAINS("contains", "包含"),

    NOT_CONTAINS("not contains", "不包含"),

    CONTAINS_ALL("contains all", "全包含"),

    NTO_CONTAINS_ALL("not contains all", "全不包含"),

    ;

    private final String code;

    private final String desc;

    private static Map<String, OperatorEum> operatorEumMap;

    static {
        operatorEumMap = Arrays.stream(OperatorEum.values())
                .collect(Collectors.toMap(OperatorEum::getCode, Function.identity(), (o, n) -> n));
    }


    public static Optional<OperatorEum> operatorEum(String code) {
        return Optional.ofNullable(operatorEumMap.get(code));
    }
}
