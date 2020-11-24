package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RuleAction {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 动作值
     */
    private String actionValue;

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