package com.weweibuy.brms.support;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleAction;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.drools.decisiontable.parser.ActionType;
import org.drools.decisiontable.parser.RhsBuilder;
import org.drools.template.model.Consequence;
import org.drools.template.model.Import;
import org.drools.template.model.Package;
import org.springframework.stereotype.Component;

import java.util.List;

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
        String resultModelPut = RuleBuildConstant.RESULT_MODEL_PUT;
        rhsBuilder.addTemplate(0, 0, resultModelPut);
        String paramStr = paramStr(rulePackage, outputModelKey, attrKey, ruleAction.getActionValue());
        rhsBuilder.addCellValue(0, 0, DrlBuildSupport.formatString(attrKey) + "," + paramStr);
        consequence.setSnippet(rhsBuilder.getResult());
        return consequence;
    }

    private String paramStr(Package rulePackage, String modelKey, String attrName, String attrValue) {
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
                addCollectionImportNecessary(rulePackage);
                return DrlBuildSupport.formatActionCollection(attrValue);
            default:
        }
        return attrValue;
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

    public static void main(String[] args) {

    }

}
