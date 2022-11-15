package com.weweibuy.brms.utils;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.weweibuy.brms.api.model.constant.RuleBuildConstant;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.scijava.parsington.ExpressionParser;
import org.scijava.parsington.Variable;
import org.scijava.parsington.eval.DefaultEvaluator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 计算工具
 *
 * @author durenhao
 * @date 2020/11/30 22:12
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DroolsCalculateUtils {

    /**
     * 计算
     *
     * @param model   模型
     * @param formula 计算公式
     * @param scale   保留位数
     * @return
     */
    public static Number calculate(Map<String, Object> model, String formula, Integer scale, String roundingMode) {

        if (StringUtils.isBlank(formula)) {
            throw Exceptions.business("计算公式错误");
        }

        ExpressRunner expressRunner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.putAll(model);

        Object result = qlExpressCalculate(model, formula);

        BigDecimal bigDecimal = new BigDecimal(result.toString());
        if (scale != null && StringUtils.isNotBlank(roundingMode)) {
            bigDecimal = bigDecimal.setScale(scale, RoundingMode.valueOf(roundingMode));
        }
        return bigDecimal;
    }

    /**
     * QLExpress 计算
     * https://github.com/alibaba/QLExpress
     *
     * @param model
     * @param formula
     * @return
     */
    public static Object qlExpressCalculate(Map<String, Object> model, String formula) {
        ExpressRunner expressRunner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.putAll(model);

        try {
            return expressRunner.execute(formula, context, null, true, false);
        } catch (Exception e) {
            throw Exceptions.formatBusiness("计算公式: %s, 错误: %s", formula, e.getMessage());
        }
    }

    /**
     * 使用 scijava 进行计算
     * https://github.com/scijava/parsington
     *
     * @return
     */
    public static Object scijavaCalculate(Map<String, Object> model, String formula) {
        ExpressionParser expressionParser = new ExpressionParser();
        DefaultEvaluator evaluator = new DefaultEvaluator(expressionParser);
        LinkedList<Object> objects = expressionParser.parsePostfix(formula);

        List<Variable> variableNameList = objects.stream()
                .filter(o -> o instanceof Variable)
                .map(o -> (Variable) o)
                .collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(variableNameList)) {
            variableNameList.forEach(name ->
                    evaluator.set(name, getValue(name.getToken(), model)));
        }
        try {
            return evaluator.evaluate(objects);
        } catch (Exception e) {
            throw Exceptions.formatBusiness("计算公式: %s, 错误: %s", formula, e.getMessage());
        }
    }


    private static Number getValue(String name, Map<String, Object> model) {
        return getValueFromMap(name, model)
                .map(Object::toString)
                .map(Double::valueOf)
                .orElseThrow(() -> Exceptions.formatBusiness("计算属性: %s 不存在或对应值错误", name));
    }

    private static Optional<Object> getValueFromMap(String name, Map<String, Object> model) {
        if (name.indexOf(RuleBuildConstant.FORMULA_ATTR_SEPARATOR) == -1) {
            return Optional.ofNullable(model.get(name));
        }

        String[] nameArr = name.split(RuleBuildConstant.FORMULA_ATTR_SEPARATOR);
        Object value = null;
        for (int i = 0; i < nameArr.length; i++) {
            value = model.get(nameArr[i]);
            if (i != nameArr.length - 1) {
                if (!(value instanceof Map)) {
                    throw Exceptions.formatBusiness("计算属性: %s 中 %s 不存在或对应值错误", name, nameArr[i]);
                }
                model = (Map<String, Object>) value;
            }
        }
        return Optional.ofNullable(value);

    }

}
