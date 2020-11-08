package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Model {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 模型key
     */
    private String modelKey;

    /**
     * 模型描述
     */
    private String modelDesc;

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