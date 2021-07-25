package com.weweibuy.brms.support;

import com.weweibuy.brms.api.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.api.model.eum.OperatorEum;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleCondition;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.utils.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/11/14 9:48
 **/
@Component
public class NotCollectionConditionBuilder implements ConditionBuilder {
    @Override
    public boolean match(RuleCondition ruleCondition, ModelAttr modelAttr) {
        ModelAttrTypeEum modelAttrTypeEum = ModelAttrTypeEum.valueOf(modelAttr.getAttrType());
        return !(ModelAttrTypeEum.COLLECTION_NUMBER.equals(modelAttrTypeEum) || ModelAttrTypeEum.COLLECTION_STRING.equals(modelAttrTypeEum));
    }

    @Override
    public String buildConditionStr(Package rulePackage, RuleCondition ruleCondition, ConditionBuildContext conditionBuildContext) {
        ModelAttr modelAttr = conditionBuildContext.getModelAttr();
        List<String> paramList = conditionBuildContext.getParamList();
        int index = conditionBuildContext.getConditionIndex();

        String attrName = ruleCondition.getAttrName();
        String template = String.format("%s %s %s", attrName, ruleCondition.getConditionOperator(), "$" + (index + 1));

        if (conditionBuildContext.getNesting()) {
            String conditionStr = DrlBuildSupport.buildNestingConditionStr(conditionBuildContext.getOriConditionAttrArr());
            template = String.format("%s && %s", conditionStr, template);
        }
        if (conditionBuildContext.getMaxIndex() != 0) {
            template = "(" + template + ")";
        }

        String paramStr = paramStr(ruleCondition, modelAttr);
        paramList.add(paramStr);
        return template;
    }

    private String paramStr(RuleCondition ruleCondition, ModelAttr modelAttr) {
        String attrValue = ruleCondition.getConditionValue();
        String attrType = modelAttr.getAttrType();
        String conditionOperator = ruleCondition.getConditionOperator();

        ModelAttrTypeEum modelAttrTypeEum = ModelAttrTypeEum.valueOf(attrType);

        if (StringUtils.equalsAny(conditionOperator, OperatorEum.ALL_MEMBER_OF.getCode(), OperatorEum.NOT_ALL_MEMBER_OF.getCode())) {
            throw Exceptions.business(String.format("属性: %s, 类型:%s, 不支持操作符:%s", modelAttr.getAttrName(), attrType, conditionOperator));
        }

        if (conditionOperator.equals(OperatorEum.MEMBER_OF.getCode()) || conditionOperator.equals(OperatorEum.NOT_MEMBER_OF.getCode())) {
            switch (modelAttrTypeEum) {
                case NUMBER:
                    return DrlBuildSupport.formatNumberCollection(attrValue);
                case STRING:
                    return DrlBuildSupport.formatStringCollection(attrValue);
                default:
                    throw Exceptions.business(String.format("操作符: %s, 不支持的数据类型: %s", conditionOperator, modelAttrTypeEum));
            }
        }

        switch (modelAttrTypeEum) {
            case NUMBER:
                return attrValue;
            case STRING:
                return DrlBuildSupport.formatString(attrValue);
            case DATE_DAY:
                return DateTimeUtils.strDateToMilli(attrValue) + "";
            case DATE_SECOND:
                return DateTimeUtils.strDateTimeToMilli(attrValue) + "";
            case BOOLEAN:
                return attrValue;
            default:
        }
        return attrValue;
    }

}
