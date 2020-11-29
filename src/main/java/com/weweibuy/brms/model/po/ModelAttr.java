package com.weweibuy.brms.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ModelAttr {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 模型key
     */
    private String modelKey;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性描述
     */
    private String attrDesc;

    /**
     * 属性类型(STRING,NUMBER,BOOLEAN,DATE,COLLECTION)
     */
    private String attrType;

    /**
     * 属性模型(适用于OBJECT类型属性)
     */
    private String attrModelKeyRef;

    /**
     * 属性值来源(INPUT,DICT,ADDRESS)
     */
    private String attrValueSource;

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