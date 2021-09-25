package com.weweibuy.brms.utils;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DroolsCalculateUtilsTest {

    @Test
    public void calculate() throws Exception {
        Map env = new HashMap<>();
        env.put("price", new BigDecimal(1000));
        env.put("qty", new BigDecimal(3));
        Object execute = AviatorEvaluator.execute("price / qty + qty", env);
        System.out.println(execute);
    }

}