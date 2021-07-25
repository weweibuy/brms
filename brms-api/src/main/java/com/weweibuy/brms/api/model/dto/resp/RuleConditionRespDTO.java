package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/25 16:20
 **/
@Data
public class RuleConditionRespDTO {

    /**
     * id自增1
     */
    private Long id;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 条件符
     */
    private String conditionOperator;

    /**
     * 条件值
     */
    private String conditionValue;

    /**
     * 逻辑运算符(与下一个条件的逻辑运算符;取值: &&,|| )
     */
    private String logicalOperator;

    /**
     * 排序(多个条件通过order排序,值越小越靠前,并通过 logical_operator 字段进行连接)
     */
    private Integer conditionOrder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
