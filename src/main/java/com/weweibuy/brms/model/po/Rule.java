package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Rule {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 规则
     */
    private String ruleKey;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 规则属性
     */
    private String ruleAttr;

    /**
     * 规则lhs
     */
    private String ruleLhs;

    /**
     * 规则rhs
     */
    private String ruleRhs;

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