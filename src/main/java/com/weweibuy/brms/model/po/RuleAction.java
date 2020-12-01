package com.weweibuy.brms.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RuleAction {
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
     * 动作值
     */
    private String actionValue;

    /**
     * 动作值类型(INPUT:直接输入型; CALCULATE:计算型)
     */
    private String actionValueType;

    /**
     * 动作值计算公式(CALCULATE 类型下有效)
     */
    private String valueCalculateFormula;

    /**
     * 计算保留位数
     */
    private Integer calculateScale;

    /**
     * 计算取整方式
     */
    private String calculateRoundingMode;

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