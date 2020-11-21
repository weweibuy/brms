package com.weweibuy.brms.drools.filter;

import org.apache.commons.collections4.CollectionUtils;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/21 19:44
 **/
public class RulePackageAndNameFilter implements AgendaFilter {

    private String packageName;

    private Set<String> ruleNames;

    public RulePackageAndNameFilter(String packageName, String[] ruleNames) {
        this(packageName, Optional.ofNullable(ruleNames)
                .map(arr -> Arrays.stream(arr).collect(Collectors.toSet()))
                .orElse(Collections.emptySet()));
    }

    public RulePackageAndNameFilter(String packageName, Set<String> ruleNames) {
        this.packageName = packageName;
        this.ruleNames = Optional.ofNullable(ruleNames)
                .orElse(Collections.emptySet());
    }

    @Override
    public boolean accept(Match match) {
        Rule rule = match.getRule();
        boolean equals = rule.getPackageName().equals(packageName);
        if (equals && CollectionUtils.isNotEmpty(ruleNames)) {
            return ruleNames.contains(rule.getName());
        }
        return equals;
    }
}
