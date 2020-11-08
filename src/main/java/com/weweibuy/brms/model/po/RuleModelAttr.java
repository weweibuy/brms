package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RuleModelAttr {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 规则
     */
    private String ruleKey;

    /**
     * 类型(LHS,RHS)
     */
    private String ruleModelAttrType;

    /**
     * 属性key
     */
    private String attrKey;

    /**
     * 属性值
     */
    private String attrValue;

    /**
     * 是否删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}