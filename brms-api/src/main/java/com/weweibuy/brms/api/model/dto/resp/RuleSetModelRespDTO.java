package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/25 16:06
 **/
@Data
public class RuleSetModelRespDTO {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
