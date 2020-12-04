package com.weweibuy.brms;

import com.weweibuy.framework.common.core.model.constant.CommonConstant;
import com.weweibuy.framework.rocketmq.annotation.EnableRocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author durenhao
 * @date 2020/11/8 11:32
 **/
@EnableRocket
@SpringBootApplication
@EnableCaching
public class BrmsApplication {

    public static void main(String[] args) {
        System.setProperty("drools.dateformat", CommonConstant.DateConstant.STANDARD_DATE_TIME_FORMAT_STR);
        SpringApplication.run(BrmsApplication.class, args);
    }


}
