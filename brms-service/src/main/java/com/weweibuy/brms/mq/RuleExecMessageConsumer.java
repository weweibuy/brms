package com.weweibuy.brms.mq;

import com.weweibuy.brms.api.model.dto.RuleExecRespDTO;
import com.weweibuy.brms.api.model.message.RuleExecMessage;
import com.weweibuy.brms.api.model.message.RuleExecResultMessage;
import com.weweibuy.brms.service.RuleExecService;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.framework.rocketmq.annotation.Payload;
import com.weweibuy.framework.rocketmq.annotation.RocketConsumerHandler;
import com.weweibuy.framework.rocketmq.annotation.RocketListener;
import com.weweibuy.framework.rocketmq.core.producer.RocketProducerRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * 消费MQ消息
 *
 * @author durenhao
 * @date 2020/12/4 22:20
 **/
@Component
@RocketListener(topic = "rocket-mq.consumer.rule.topic", group = "BRMS_RULE_CG")
@RequiredArgsConstructor
@ConditionalOnBean(RocketProducerRegister.class)
public class RuleExecMessageConsumer {

    private final RuleExecService ruleExecService;

    private final RuleExecResultProvider ruleExecResultProvider;

    @RocketConsumerHandler
    public void onMessage(@Payload RuleExecMessage message) {
        RuleExecRespDTO ruleExecRespDTO = ruleExecService.execRule(message);
        String callBackTag = message.getCallBackTag();
        RuleExecResultMessage resultMessage = BeanCopyUtils.copy(ruleExecRespDTO, RuleExecResultMessage.class);
        resultMessage.setReqNo(message.getReqNo());
        ruleExecResultProvider.send(resultMessage, callBackTag);
    }


}
