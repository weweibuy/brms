package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/23 21:43
 **/
@Data
public class RuleSetRespDTO {

    /**
     * id自增1
     */
    private Long id;

    /**
     * 规则集key(package)
     */
    private String ruleSetKey;

    /**
     * 规则集名称
     */
    private String ruleSetName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
