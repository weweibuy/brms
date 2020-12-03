package com.weweibuy.brms.drools;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.context.RuleProcessContext;
import com.weweibuy.brms.model.event.RuleHitLogEvent;
import com.weweibuy.brms.support.RuleProcessContextHolder;
import com.weweibuy.framework.common.core.concurrent.LogExceptionThreadFactory;
import com.weweibuy.framework.common.core.utils.IdWorker;
import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import com.weweibuy.framework.common.log.support.LogTraceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.common.DefaultAgenda;
import org.drools.core.common.DefaultFactHandle;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class RuleLogEventListener extends DefaultAgendaEventListener {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100), new LogExceptionThreadFactory("rule-hit-log-"), new ThreadPoolExecutor.DiscardPolicy());

    private final ApplicationContext applicationContext;


    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {


        try {
            KieRuntime kieRuntime = event.getKieRuntime();
            Agenda agenda = kieRuntime.getAgenda();
            String agendaGroupName = "";
            if (agenda instanceof DefaultAgenda) {
                agendaGroupName = ((DefaultAgenda) agenda).getFocus().getName();
            }

            Object global = kieRuntime.getGlobal(RuleBuildConstant.RESULT_MODEL);
            Rule rule = event.getMatch().getRule();
            String packageName = rule.getPackageName();
            String name = rule.getName();

            processContext(packageName, name, agendaGroupName);

            FactHandle factHandle = event.getMatch().getFactHandles().get(0);
            String inputModel = "";
            if (factHandle instanceof DefaultFactHandle) {
                inputModel = JackJsonUtils.write(((DefaultFactHandle) factHandle).getObject());
            }

            Map<String, Object> resultMap = (Map) global;
            resultMap.put(RuleBuildConstant.RULE_HIT_FLAG_NAME, true);
            String outputModel = JackJsonUtils.write(global);
            RuleHitLogEvent logEvent = RuleHitLogEvent.builder()
                    .ruleSetKey(packageName)
                    .ruleKey(name)
                    .agendaGroup(agendaGroupName)
                    .inputModel(inputModel)
                    .outputModel(outputModel)
                    .requestNo(LogTraceContext.getTraceCode().orElse(IdWorker.nextStringId()))
                    .build();
            pushHitEvent(logEvent);
        } catch (Exception e) {
            log.warn("输出规则命中日志异常: ", e);
        }
    }


    private void processContext(String packageName, String ruleName, String agendaGroupName) {
        RuleProcessContextHolder.getContext().map(c -> {
            c.setHit(true);
            return c;
        })
                .map(RuleProcessContext::getProcessRuleSetMap)
                .map(map -> map.get(packageName))
                .map(RuleProcessContext.ProcessRuleSet::getProcessRuleMap)
                .map(map -> map.get(ruleName))
                .ifPresent(rule -> {
                    rule.setHit(true);
                    rule.setAgendaGroup(agendaGroupName);
                });

    }

    private void pushHitEvent(RuleHitLogEvent event) {
        EXECUTOR.execute(() -> applicationContext.publishEvent(event));
    }

}
