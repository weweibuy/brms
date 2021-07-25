package com.weweibuy.brms.api.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/25 16:20
 **/
@Data
public class RuleActionRespDTO {

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
