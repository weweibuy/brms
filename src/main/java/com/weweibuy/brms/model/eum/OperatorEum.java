package com.weweibuy.brms.model.eum;

import lombok.Getter;

/**
 * 操作符
 *
 * @author durenhao
 * @date 2020/11/12 21:48
 **/
@Getter
public enum OperatorEum {

    MEMBER_OF("memberOf"),

    NOT_MEMBER_OF("not memberOf"),

    CONTAINS("contains"),

    NOT_CONTAINS("not contains"),

    ;

    private String code;

    OperatorEum(String code) {
        this.code = code;
    }
}
