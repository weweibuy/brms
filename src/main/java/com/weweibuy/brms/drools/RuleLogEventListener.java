package com.weweibuy.brms.drools;

import com.weweibuy.brms.model.constant.RuleBuildConstant;
import com.weweibuy.brms.model.event.RuleHitLogEvent;
import com.weweibuy.framework.common.core.concurrent.LogExceptionThreadFactory;
import com.weweibuy.framework.common.core.utils.IdWorker;
import com.weweibuy.framework.common.core.utils.JackJsonUtils;
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

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/9/9
 * @since 7.37.0.Final
 */
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
            FactHandle factHandle = event.getMatch().getFactHandles().get(0);
            String inputModel = "";
            if (factHandle instanceof DefaultFactHandle) {
                inputModel = JackJsonUtils.write(((DefaultFactHandle) factHandle).getObject());
            }
            String packageName = rule.getPackageName();
            String name = rule.getName();
            String outputModel = JackJsonUtils.write(global);
            log.info("规则集 {}, 命中规则: {}, 议程组: {}, 请求模型: {}, 响应模型: {}",
                    packageName, name, agendaGroupName,
                    inputModel, outputModel);
            RuleHitLogEvent logEvent = RuleHitLogEvent.builder()
                    .ruleSetKey(packageName)
                    .ruleKey(name)
                    .agendaGroup(agendaGroupName)
                    .inputModel(inputModel)
                    .outputModel(outputModel)
                    .requestNo(IdWorker.nextStringId())
                    .build();
            pushHitEvent(logEvent);
        } catch (Exception e) {
            log.warn("输出规则命中日志异常: ", e);
        }
    }

    private void pushHitEvent(RuleHitLogEvent event) {
        EXECUTOR.execute(() -> applicationContext.publishEvent(event));
    }

}
