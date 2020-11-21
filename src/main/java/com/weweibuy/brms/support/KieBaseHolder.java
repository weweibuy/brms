package com.weweibuy.brms.support;

import com.weweibuy.brms.manager.RuleBuildManager;
import com.weweibuy.framework.common.core.exception.Exceptions;
import lombok.RequiredArgsConstructor;
import org.drools.core.impl.KnowledgeBaseImpl;
import org.drools.core.io.impl.ByteArrayResource;
import org.kie.api.KieBase;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Component;

import java.util.Collection;
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

    public KieBase findKieBase(String namespace) {
        return kieBaseMap.computeIfAbsent(namespace, this::buildKieBase);
    }

    public void addPackage(String namespace, String ruleSetKey) {
        KieBase kieBase = kieBaseMap.get(namespace);
        if (kieBase == null) {
            throw Exceptions.business("当前 kieBase 不存在");
        }
        if (kieBase.getKiePackage(ruleSetKey) != null) {
            throw Exceptions.business("当前 package 已经存在");
        }
        KnowledgeBaseImpl knowledgeBase = (KnowledgeBaseImpl) kieBase;
        Collection<KiePackage> kiePackages = buildKiePackage(namespace, ruleSetKey);
        kiePackages.stream()
                .filter(p -> kieBase.getKiePackage(p.getName()) == null)
                .forEach(knowledgeBase::addPackage);
    }

    public void removePackage(String namespace, String ruleSetKey) {
        KieBase kieBase = kieBaseMap.get(namespace);
        if (kieBase != null && kieBase.getKiePackage(ruleSetKey) != null) {
            kieBase.removeKiePackage(ruleSetKey);
        }
    }


    private KieBase buildKieBase(String namespace) {
        KieHelper kieHelper = new KieHelper();
        ruleBuildManager.buildNamespaceRules(namespace)
                .forEach(str -> kieHelper.addContent(str, ResourceType.DRL));
        return kieHelper.build();
    }

    private Collection<KiePackage> buildKiePackage(String namespace, String ruleSetKey) {
        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
        String rules = ruleBuildManager.buildNamespaceRules(namespace, ruleSetKey);

        ByteArrayResource byteArrayResource = new ByteArrayResource(rules.getBytes());

        kb.add(byteArrayResource, ResourceType.DRL);

        Collection<KiePackage> knowledgePackages = kb.getKnowledgePackages();
        return knowledgePackages;
    }

}
