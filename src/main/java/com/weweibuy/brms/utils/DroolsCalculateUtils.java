package com.weweibuy.brms.utils;

import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nfunk.jep.JEP;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 计算工具
 *
 * @author durenhao
 * @date 2020/11/30 22:12
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DroolsCalculateUtils {

    private static final String REGEX = "\\-|\\+|\\*|\\/|\\d|\\s+";

    /**
     * 计算
     *
     * @param model   模型
     * @param formula 计算公式
     * @param scale   保留位数
     * @return
     */
    public static String calculate(Map<String, Object> model, String formula, Integer scale, String roundingMode) {

        if (StringUtils.isBlank(formula)) {
            throw Exceptions.business("计算公式错误");
        }
        List<String> variableNameList = Arrays.stream(formula.split(REGEX))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
        JEP jep = new JEP();
        jep.parseExpression(formula);
        Object result = null;
        if (CollectionUtils.isEmpty(variableNameList)) {
            result = jep.getValueAsObject();
        } else {
            variableNameList.forEach(name ->
                    jep.addVariable(name, getValue(name, model)));
        }
        BigDecimal bigDecimal = new BigDecimal(result.toString());
        if (scale != null && StringUtils.isBlank(roundingMode)) {
            bigDecimal = bigDecimal.setScale(scale, RoundingMode.valueOf(roundingMode));
        }
        return bigDecimal.toString();
    }


    private static Double getValue(String name, Map<String, Object> model) {
        return Optional.ofNullable(getValueFromMap(name, model))
                .map(Object::toString)
                .filter(StringUtils::isNumeric)
                .map(BigDecimal::new)
                .map(BigDecimal::doubleValue)
                .orElseThrow(() -> Exceptions.formatBusiness("计算属性: %s 不存在或对应值错误", name));
    }

    private static Optional<Object> getValueFromMap(String name, Map<String, Object> model) {
        if (name.indexOf('.') == -1) {
            return Optional.ofNullable(model.get(name));
        }

        String[] nameArr = name.split("\\.");
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
