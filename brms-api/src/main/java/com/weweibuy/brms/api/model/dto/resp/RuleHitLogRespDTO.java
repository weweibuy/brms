package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/25 16:38
 **/
@Data
public class RuleHitLogRespDTO {

    /**
     * id自增1
     */
    private Long id;

    /**
     * 流水号
     */
    private String requestNo;

    /**
     * 规则集key(package)
     */
    private String ruleSetKey;

    /**
     * 议程组
     */
    private String agendaGroup;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 输入模型(Json)
     */
    private String inputModel;

    /**
     * 输出模型(Json)
     */
    private String outputModel;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
