package com.weweibuy.brms.manager;

import com.weweibuy.brms.model.event.RuleHitLogEvent;
import com.weweibuy.brms.repository.RuleHitLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.UnicastProcessor;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;

/**
 * 操作日志管理
 *
 * @author durenhao
 * @date 2019/11/16 17:35
 **/
@Slf4j
@Component
public class RuleHitLogLogManager {

    private final UnicastProcessor<RuleHitLogEvent> listener;

    private final RuleHitLogRepository ruleHitLogRepository;

    public RuleHitLogLogManager(RuleHitLogRepository ruleHitLogRepository) {
        this.ruleHitLogRepository = ruleHitLogRepository;
        this.listener = UnicastProcessor.<RuleHitLogEvent>create();
        init();
    }

    private void init() {
        listener.publish()
                .autoConnect()
                .onBackpressureDrop()
                .bufferTimeout(200, Duration.ofMinutes(1), Schedulers.single())
                .subscribe(this::doStatistics);
    }

    /**
     * 保存日志
     *
     * @param eventList
     */
    private void doStatistics(List<RuleHitLogEvent> eventList) {
        try {
            eventList.stream()
                    .map(RuleHitLogEvent::toRuleHitLog)
                    .forEach(ruleHitLogRepository::insert);
        } catch (Exception e) {
            log.warn("保存规则命中日志异常: ", e);
        }
    }

    @EventListener
    public void onRuleHitLogEvent(RuleHitLogEvent event) {
        listener.onNext(event);
    }

}
