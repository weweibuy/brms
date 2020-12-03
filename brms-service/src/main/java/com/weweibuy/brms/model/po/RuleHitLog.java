package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RuleHitLog {
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