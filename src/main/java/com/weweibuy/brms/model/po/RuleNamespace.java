package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RuleNamespace {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 名称空间
     */
    private String namespace;

    /**
     * 名称空间描述
     */
    private String namespaceDesc;

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