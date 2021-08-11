package com.weweibuy.brms;

import com.weweibuy.framework.common.core.model.constant.CommonConstant;
import com.weweibuy.framework.rocketmq.annotation.EnableRocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 业务规则系统
 *
 * @author durenhao
 * @date 2020/11/8 11:32
 **/
@EnableRocket(basePackages = {"com.weweibuy.brms.BrmsApplication",
        "com.weweibuy.framework.common.lc.mq"})
@SpringBootApplication
@EnableCaching
public class BrmsApplication {

    public static void main(String[] args) {
        System.setProperty("drools.dateformat", CommonConstant.DateConstant.STANDARD_DATE_TIME_FORMAT_STR);
        SpringApplication.run(BrmsApplication.class, args);
    }


}
