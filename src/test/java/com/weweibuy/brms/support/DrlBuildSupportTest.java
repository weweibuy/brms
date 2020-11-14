package com.weweibuy.brms.support;

import org.junit.Test;

public class DrlBuildSupportTest {

    @Test
    public void formatString() throws Exception {
        String s = DrlBuildSupport.formatString("111");
        System.err.println(s);
    }

}