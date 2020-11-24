package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RuleSetModel {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 模型key
     */
    private String modelKey;

    /**
     * 规则集key(package)
     */
    private String ruleSetKey;

    /**
     * 模型类型(INPUT:输入; OUTPUT:输出)
     */
    private String modelType;

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