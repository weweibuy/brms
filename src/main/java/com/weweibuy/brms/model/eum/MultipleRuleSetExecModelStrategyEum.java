package com.weweibuy.brms.model.eum;

/**
 * 多规则集执行时,模型转化策略
 *
 * @author durenhao
 * @date 2020/11/24 21:38
 **/
public enum MultipleRuleSetExecModelStrategyEum {

    /**
     * 使用规则 action的模型作为下一个规则的输入模型
     */
    USE_ACTION_MODEL,

    /**
     * 总是使用第一的模型
     */
    ALWAYS_USE_FIRST,


    ;

}
