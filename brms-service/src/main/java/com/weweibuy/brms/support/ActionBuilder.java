package com.weweibuy.brms.support;

import com.weweibuy.brms.api.model.constant.RuleBuildConstant;
import com.weweibuy.brms.api.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.api.model.eum.RuleActionValueTypeEum;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleAction;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.drools.decisiontable.parser.ActionType;
import org.drools.decisiontable.parser.RhsBuilder;
import org.drools.template.model.Consequence;
import org.drools.template.model.Import;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/14 11:14
 **/
@Component
@RequiredArgsConstructor
public class ActionBuilder {

    private final ModelAndAttrRepository modelAndAttrRepository;

    public Consequence buildRuleAction(Package rulePackage, String outputModelKey, RuleAction ruleAction) {
        RhsBuilder rhsBuilder = new RhsBuilder(ActionType.Code.ACTION, 0, 0, null);
        Consequence consequence = new Consequence();

        String attrKey = ruleAction.getAttrName();

        RuleActionValueTypeEum valueType = RuleActionValueTypeEum.valueOf(ruleAction.getActionValueType());
        String paramStr = null;
        switch (valueType) {
            case INPUT:
                paramStr = paramInputStr(rulePackage, outputModelKey, attrKey, ruleAction.getActionValue());
                break;
            case CALCULATE:
                paramStr = paramCalculateStr(rulePackage, outputModelKey, ruleAction);
                break;
            default:
                throw Exceptions.formatBusiness("不支持的规则动作值类型: %s", valueType);
        }


        String resultModelPut = RuleBuildConstant.RESULT_MODEL_PUT;
        rhsBuilder.addTemplate(0, 0, resultModelPut);
        rhsBuilder.addCellValue(0, 0, DrlBuildSupport.formatString(attrKey) + "," + paramStr);
        consequence.setSnippet(rhsBuilder.getResult());
        return consequence;
    }


    private String paramCalculateStr(Package rulePackage, String outputModelKey, RuleAction ruleAction) {
        String formula = ruleAction.getValueCalculateFormula();
        Integer scale = ruleAction.getCalculateScale();
        String roundingMode = Optional.ofNullable(ruleAction.getCalculateRoundingMode())
                .filter(StringUtils::isNotBlank)
                .orElse(RoundingMode.HALF_UP.toString());
        String calculateUtilsMethod = RuleBuildConstant.CALCULATE_UTILS_METHOD;

        addImportNecessary(rulePackage, RuleBuildConstant.CALCULATE_UTILS);
        formula = DrlBuildSupport.formatString(formula);
        roundingMode = DrlBuildSupport.formatString(roundingMode);
        return String.format(calculateUtilsMethod, RuleBuildConstant.MODEL, formula, scale, roundingMode);
    }


    private String paramInputStr(Package rulePackage, String modelKey, String attrName, String attrValue) {
        ModelAttr modelAttr = modelAndAttrRepository.selectModelAttr(modelKey, attrName)
                .orElseThrow(() -> Exceptions.business(String.format("模型: %s, 属性 %s 不存在", modelKey, attrName)));
        String attrType = modelAttr.getAttrType();

        ModelAttrTypeEum modelAttrTypeEum = ModelAttrTypeEum.valueOf(attrType);
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
            case COLLECTION_NUMBER:
            case COLLECTION_STRING:
                addImportNecessary(rulePackage, RuleBuildConstant.COLLECTION_UTILS);
                return DrlBuildSupport.formatActionCollection(attrValue);
            default:
        }
        return attrValue;
    }


    private void addImportNecessary(Package rulePackage, String importClazzName) {
        List<Import> importList = rulePackage.getImports();
        boolean b = importList.stream()
                .anyMatch(i -> i.getClassName().equals(importClazzName));
        if (!b) {
            Import anImport = new Import();
            anImport.setClassName(importClazzName);
            rulePackage.addImport(anImport);
        }
    }


}
