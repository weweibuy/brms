package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/25 16:55
 **/
@Data
public class RuleModelAttrRespDTO {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
