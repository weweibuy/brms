package com.weweibuy.brms.support;

/**
 * @author durenhao
 * @date 2020/11/12 21:01
 **/
public class DrlBuildSupport {

    private static final String STR_FORMAT = "\"%s\"";

    private static final String COLLECTION_FORMAT = "[%s]";

    public static String formatString(String stringValue) {
        return String.format(STR_FORMAT, stringValue);
    }

    public static String formatCollection(String stringValue) {
        return String.format(COLLECTION_FORMAT, stringValue);
    }


}
