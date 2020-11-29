package com.weweibuy.brms.support;

import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleCondition;
import org.drools.template.model.Package;

/**
 * 规则条件构建
 *
 * @author durenhao
 * @date 2020/11/13 22:58
 **/
public interface ConditionBuilder {

    /**
     * 匹配
     *
     * @param ruleCondition
     * @param modelAttr
     * @return
     */
    boolean match(RuleCondition ruleCondition, ModelAttr modelAttr);

    /**
     * 构建
     *
     * @param rulePackage
     * @param ruleCondition
     * @param conditionBuildContext
     * @return
     */
    String buildConditionStr(Package rulePackage, RuleCondition ruleCondition, ConditionBuildContext conditionBuildContext);



}
