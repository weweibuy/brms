package com.weweibuy.brms.api.model.eum;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 操作符
 *
 * @author durenhao
 * @date 2020/11/12 21:48
 **/
@Getter
public enum OperatorEum {

    MEMBER_OF("memberOf"),

    ALL_MEMBER_OF("all memberOf"),

    NOT_MEMBER_OF("not memberOf"),

    NOT_ALL_MEMBER_OF("not all memberOf"),

    CONTAINS("contains"),

    NOT_CONTAINS("not contains"),

    CONTAINS_ALL("contains all"),

    NTO_CONTAINS_ALL("not contains all"),;

    private String code;

    private static Map<String, OperatorEum> operatorEumMap;

    static {
        operatorEumMap = Arrays.stream(OperatorEum.values())
                .collect(Collectors.toMap(OperatorEum::getCode, Function.identity(), (o, n) -> n));
    }

    OperatorEum(String code) {
        this.code = code;
    }


    public static Optional<OperatorEum> operatorEum(String code) {
        return Optional.ofNullable(operatorEumMap.get(code));
    }
}
