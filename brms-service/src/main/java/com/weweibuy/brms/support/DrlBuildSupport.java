package com.weweibuy.brms.support;

import com.weweibuy.brms.api.model.constant.RuleBuildConstant;
import com.weweibuy.framework.common.core.model.constant.CommonConstant;
import org.drools.decisiontable.parser.LhsBuilder;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/12 21:01
 **/
public class DrlBuildSupport {

    private static final String STR_FORMAT = "\"%s\"";

    private static final String COLLECTION_FORMAT = "[%s]";

    private static final String ACTION_COLLECTION_FORMAT = "DroolsCollectionUtils.toList(%s)";


    public static String formatString(String stringValue) {
        return String.format(STR_FORMAT, stringValue);
    }

    public static String formatStringCollection(String stringValue) {
        return Arrays.stream(stringValue.split(CommonConstant.COMMA_STR))
                .map(DrlBuildSupport::formatString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static String formatNumberCollection(String stringValue) {
        return String.format(COLLECTION_FORMAT, stringValue);
    }

    public static String formatActionCollection(String stringValue) {
        return String.format(ACTION_COLLECTION_FORMAT, stringValue);
    }


    public static String buildConditionStr(String template, String param) {
        LhsBuilder lhsBuilder = new LhsBuilder(0, 0, RuleBuildConstant.CONDITION_MODEL);
        lhsBuilder.addTemplate(0, 0, template);
        lhsBuilder.addCellValue(0, 0, param);
        return lhsBuilder.getResult();
    }

    public static String buildNestingConditionStr(String[] oriAttr) {
        String[] attr = new String[oriAttr.length - 1];
        System.arraycopy(oriAttr, 0, attr, 0, oriAttr.length - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < attr.length; i++) {
            for (int j = 0; j <= i; j++) {
                stringBuilder.append(attr[j]);
                if (j != i) {
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append(" != null");
            if (i != attr.length - 1) {
                stringBuilder.append(" && ");
            }
        }
        return stringBuilder.toString();
    }


}
