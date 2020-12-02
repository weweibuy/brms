package com.weweibuy.brms.utils;

import org.junit.Test;

import java.util.HashMap;

public class DroolsCalculateUtilsTest {


    @Test
    public void calculate() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("income", 300);
        String exp = "income - 3500 / income"; //给变量赋值

        String calculate = DroolsCalculateUtils.calculate(map, exp, null, null);
        System.out.println("计算结果： " + calculate);


    }



}