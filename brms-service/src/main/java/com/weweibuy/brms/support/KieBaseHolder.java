package com.weweibuy.brms.support;

import com.weweibuy.brms.manager.RuleBuildManager;
import lombok.RequiredArgsConstructor;
import org.drools.core.impl.InternalKieContainer;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author durenhao
 * @date 2020/11/8 21:16
 **/
@Component
@RequiredArgsConstructor
public class KieBaseHolder {

    private final ConcurrentHashMap<String, KieBase> kieBaseMap = new ConcurrentHashMap<>();

    private final RuleBuildManager ruleBuildManager;

    public KieBase findKieBase(String key) {
        return kieBaseMap.computeIfAbsent(key, this::buildKieBase);
    }

    public void remove(String key) {
        KieBase remove = kieBaseMap.remove(key);
        if (remove != null) {
            KnowledgeBaseImpl knowledgeBase = (KnowledgeBaseImpl) remove;
            InternalKieContainer kieContainer = knowledgeBase.getKieContainer();
            knowledgeBase.setKieContainer(null);
            kieContainer.dispose();
        }
    }


    private KieBase buildKieBase(String key) {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(ruleBuildManager.buildRuleStr(key), ResourceType.DRL);
        return kieHelper.build();
    }

}
