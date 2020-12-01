package com.weweibuy.brms.utils;

import org.junit.Test;
import org.nfunk.jep.JEP;

import java.util.Arrays;

public class DroolsCalculateUtilsTest {


    @Test
    public void calculate() throws Exception {
        JEP jep = new JEP(); //一个数学表达式
        String exp = "income - 3500"; //给变量赋值
        jep.addVariable("income", 1000);
        //执行
        jep.parseExpression(exp);
        Object result = jep.getValueAsObject();
        System.out.println("计算结果： " + result);
    }

    @Test
    public void test01() {
        String str = "-34 + aa / 34 + bb";
        String[] split = str.split("\\-|\\+|\\*|\\/|\\d|\\s+");
        System.err.println(Arrays.asList(split));

    }


}