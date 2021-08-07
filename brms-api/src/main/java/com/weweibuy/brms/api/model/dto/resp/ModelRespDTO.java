package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/29 21:30
 **/
@Data
public class ModelRespDTO {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
