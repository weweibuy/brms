package com.weweibuy.brms.service;

import com.weweibuy.brms.manager.RuleBuildManager;
import com.weweibuy.brms.support.KieBaseHolder;
import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import com.weweibuy.framework.common.lc.event.LocalCacheEvictedEvent;
import com.weweibuy.framework.common.lc.mq.LocalCacheEvictProducer;
import com.weweibuy.framework.common.lc.mq.message.LocalCacheEvictMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * @author durenhao
 * @date 2020/11/9 21:47
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class RuleManageService {

    private final RuleBuildManager ruleBuildManager;

    private final KieBaseHolder kieBaseHolder;

    private final LocalCacheEvictProducer localCacheEvictProducer;


    public String compile(String ruleSetKey) {
        return ruleBuildManager.buildRuleStr(ruleSetKey);
    }

    public void reload(String ruleSetKey) {
        Set<String> singleton = Collections.singleton(ruleSetKey);
        String write = JackJsonUtils.writeValue(singleton);
        LocalCacheEvictedEvent localCacheEvictedEvent = new LocalCacheEvictedEvent(write);
        LocalCacheEvictMessage message = LocalCacheEvictMessage.evict(null, null, localCacheEvictedEvent);
        localCacheEvictProducer.send(message);
    }

    @EventListener
    public void onCacheEvicted(LocalCacheEvictedEvent localCacheEvictedEvent) {
        // 是否重新加载规则
        String body = localCacheEvictedEvent.getBody();
        if (StringUtils.isNotBlank(body)) {
            Set<String> set = JackJsonUtils.readValue(body, Set.class);
            set.stream()
                    .forEach(this::doReload);
        }
    }


    public void doReload(String ruleSetKey) {
        try {
            kieBaseHolder.remove(ruleSetKey);
            kieBaseHolder.findKieBase(ruleSetKey);
            log.warn("重新加载规则: {}, 完成", ruleSetKey);
        } catch (Exception e) {
            log.error("重新加载规则: {}, 失败", ruleSetKey, e);
        }
    }

}
