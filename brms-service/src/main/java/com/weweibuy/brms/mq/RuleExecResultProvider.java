package com.weweibuy.brms.mq;

import com.weweibuy.brms.mq.message.RuleExecResultMessage;
import com.weweibuy.framework.rocketmq.annotation.RocketProducer;
import com.weweibuy.framework.rocketmq.annotation.RocketProducerHandler;
import com.weweibuy.framework.rocketmq.annotation.Tag;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author durenhao
 * @date 2019/12/29 10:26
 **/
@RocketProducer(topic = "${rocket-mq.producer.rule-result.topic}")
public interface RuleExecResultProvider {

    /**
     * TAG支持EL表达式的形式, 如何方法参数中有@Tag标记的值, 将覆盖注解中的值
     *
     * @return
     */
    @RocketProducerHandler
    SendResult send(RuleExecResultMessage resultMessage, @Tag String tag);


}
