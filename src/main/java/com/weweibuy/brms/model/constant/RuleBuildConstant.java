package com.weweibuy.brms.model.constant;

/**
 * @author durenhao
 * @date 2020/11/9 22:05
 **/
public interface RuleBuildConstant {

    String MAP_CLAZZ = "java.util.Map";

    String COLLECTION_UTILS = "com.weweibuy.brms.utils.DroolsCollectionUtils";

    String CALCULATE_UTILS = "com.weweibuy.brms.utils.DroolsCalculateUtils";

    String MODEL = "$model";

    String CONDITION_MODEL = "$model:Map";

    String RESULT_MODEL = "resultModel";

    String RESULT_MODEL_PUT = "resultModel.put($1, $2);";

    String RULE_HIT_FLAG_NAME = "_hit";

    String CALCULATE_UTILS_METHOD = "DroolsCalculateUtils.calculate(%s, %s, %s, %s)";

    /**
     * 计算公式分隔符
     */
    String FORMULA_ATTR_SEPARATOR = "010";

}
