package com.weweibuy.brms.support;

import com.weweibuy.brms.api.model.constant.RuleBuildConstant;
import com.weweibuy.brms.api.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.api.model.eum.OperatorEum;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleCondition;
import com.weweibuy.framework.common.core.exception.Exceptions;
import org.drools.template.model.Import;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/11/13 23:00
 **/
@Component
public class CollectionConditionBuilder implements ConditionBuilder {

    @Override
    public boolean match(RuleCondition ruleCondition, ModelAttr modelAttr) {
        ModelAttrTypeEum modelAttrTypeEum = ModelAttrTypeEum.valueOf(modelAttr.getAttrType());
        return ModelAttrTypeEum.COLLECTION_NUMBER.equals(modelAttrTypeEum) || ModelAttrTypeEum.COLLECTION_STRING.equals(modelAttrTypeEum);
    }


    @Override
    public String buildConditionStr(Package rulePackage, RuleCondition ruleCondition, ConditionBuildContext conditionBuildContext) {
        ModelAttr modelAttr = conditionBuildContext.getModelAttr();
        List<String> paramList = conditionBuildContext.getParamList();
        String attrName = modelAttr.getAttrName();

        String conditionOperator = ruleCondition.getConditionOperator();
        OperatorEum operatorEum = OperatorEum.operatorEum(conditionOperator)
                .orElseThrow(() -> Exceptions.business(conditionOperator + " :对应的操作不存在"));
        String template = null;
        int index = conditionBuildContext.getConditionIndex();
        switch (operatorEum) {
            case ALL_MEMBER_OF:
                template = String.format("DroolsCollectionUtils.allMemberOf(%s, $%s)", attrName, index + 1);
                addCollectionImportNecessary(rulePackage);
                break;
            case NOT_ALL_MEMBER_OF:
                template = String.format("!DroolsCollectionUtils.allMemberOf(%s,  $%s)", attrName, index + 1);
                addCollectionImportNecessary(rulePackage);
                break;
            case CONTAINS_ALL:
                template = String.format("DroolsCollectionUtils.containsAll(%s, $%s)", attrName, index + 1);
                addCollectionImportNecessary(rulePackage);
                break;
            case NTO_CONTAINS_ALL:
                template = String.format("!DroolsCollectionUtils.containsAll(%s,  $%s)", attrName, index + 1);
                addCollectionImportNecessary(rulePackage);
                break;
            default:
                template = String.format("%s %s $%s", attrName, ruleCondition.getConditionOperator(), index + 1);
        }

        if (conditionBuildContext.getNesting()) {
            String[] oriConditionAttrArr = conditionBuildContext.getOriConditionAttrArr();
            String nestingConditionStr = DrlBuildSupport.buildNestingConditionStr(oriConditionAttrArr);
            // 对象类型  user.dept in $1  -->  (user != null && user.dept in $1)
            template = String.format("%s && %s", nestingConditionStr, template);
        }
        if (conditionBuildContext.getMaxIndex() != 0) {
            template = "(" + template + ")";
        }

        paramList.add(paramStr(ruleCondition, modelAttr));
        return template;
    }

    private String paramStr(RuleCondition ruleCondition, ModelAttr modelAttr) {
        String conditionOperator = ruleCondition.getConditionOperator();
        String attrValue = ruleCondition.getConditionValue();
        String attrType = modelAttr.getAttrType();

        OperatorEum operatorEum = OperatorEum.operatorEum(conditionOperator)
                .orElseThrow(() -> Exceptions.business(conditionOperator + " :对应的操作不存在"));
        ModelAttrTypeEum modelAttrTypeEum = ModelAttrTypeEum.valueOf(modelAttr.getAttrType());

        switch (operatorEum) {
            case CONTAINS_ALL:
            case NTO_CONTAINS_ALL:
            case ALL_MEMBER_OF:
            case NOT_ALL_MEMBER_OF:
                if (ModelAttrTypeEum.COLLECTION_NUMBER.equals(modelAttrTypeEum)) {
                    return DrlBuildSupport.formatNumberCollection(attrValue);
                }
                if (ModelAttrTypeEum.COLLECTION_STRING.equals(modelAttrTypeEum)) {
                    return DrlBuildSupport.formatStringCollection(attrValue);
                }
                throw Exceptions.business(String.format("操作符: %s, 不支持的数据类型: %s", operatorEum, modelAttrTypeEum));
            default:
                if (ModelAttrTypeEum.COLLECTION_STRING.equals(modelAttrTypeEum)) {
                    return DrlBuildSupport.formatString(attrValue);
                }
                return attrValue;
        }
    }

    private void addCollectionImportNecessary(Package rulePackage) {
        List<Import> importList = rulePackage.getImports();
        boolean b = importList.stream()
                .anyMatch(i -> i.getClassName().equals(RuleBuildConstant.COLLECTION_UTILS));
        if (!b) {
            Import anImport = new Import();
            anImport.setClassName(RuleBuildConstant.COLLECTION_UTILS);
            rulePackage.addImport(anImport);
        }
    }

}
