package com.weweibuy.brms.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Rule {
    /**
     * id自增1
     */
    private Long id;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 规则集key(package)
     */
    private String ruleSetKey;

    /**
     * activation-group
     */
    private String activationGroup;

    /**
     * agenda-group
     */
    private String agendaGroup;

    /**
     * no-loop(false 或 true)
     */
    private String noLoop;

    /**
     * date-effective(格式yyyy-MM-DD HH:mm:ss)
     */
    private String dateEffective;

    /**
     * date-expires(格式yyyy-MM-DD HH:mm:ss)
     */
    private String dateExpires;

    /**
     * salience(优先级,值越大优先级越高)
     */
    private Integer salience;

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