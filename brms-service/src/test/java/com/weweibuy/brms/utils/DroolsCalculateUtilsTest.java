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
        env.put("qty2", new BigDecimal("3.1"));
        Object execute = AviatorEvaluator.execute("price / qty + qty", env);
        Object executeB = AviatorEvaluator.execute("1 > 0");
        Object execute1 = AviatorEvaluator.execute("qty < qty2 && qty > qty2 + 100", env);
        System.out.println(execute);
        System.out.println(execute1);
    }

}