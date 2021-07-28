package com.weweibuy.brms.support;

import com.weweibuy.brms.api.model.eum.ModelAttrTypeEum;
import com.weweibuy.brms.model.po.Model;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.model.po.RuleSetModel;
import com.weweibuy.brms.repository.JdbcModelAndAttrRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2021/7/27 22:40
 **/
@Component
@RequiredArgsConstructor
public class RuleTranslateHelper {

    private final JdbcModelAndAttrRepositoryImpl modelAndAttrRepository;


    public Map<String, String> translateAttr(RuleSetModel ruleSetModel, String keySeparator) {
        Map<String, String> container = new HashMap<>();
        modelAndAttrRepository.selectModel(ruleSetModel.getModelKey())
                .ifPresent(m -> translateAttr(m, "", m.getModelDesc(), keySeparator, container));
        return container;
    }

    private void translateAttr(Model model, String lastKey, String lastName, String keySeparator, Map<String, String> container) {
        List<ModelAttr> modelAttrList = modelAndAttrRepository.selectModelAttrByModelKey(model.getModelKey());
        Map<Boolean, List<ModelAttr>> isObjectMap = modelAttrList.stream()
                .collect(Collectors.groupingBy(a -> ModelAttrTypeEum.OBJECT.toString().equals(a.getAttrType())));
        List<ModelAttr> noObjectAttrList = isObjectMap.get(false);
        if (CollectionUtils.isNotEmpty(noObjectAttrList)) {
            noObjectAttrList.forEach(a ->
                    container.put(key(lastKey, a.getAttrName(), keySeparator), lastName + "." + a.getAttrDesc()));
        }
        List<ModelAttr> objectAttrList = isObjectMap.get(true);
        if (CollectionUtils.isNotEmpty(objectAttrList)) {
            objectAttrList.forEach(a -> modelAndAttrRepository.selectModel(a.getAttrModelKeyRef())
                    .ifPresent(m -> translateAttr(m, key(lastKey, a.getAttrName(), keySeparator),
                            lastName + "." + a.getAttrDesc(), keySeparator, container)));
        }

    }

    private String key(String lastKey, String currentKey, String keySeparator) {
        return Optional.ofNullable(lastKey)
                .filter(StringUtils::isNotBlank)
                .map(l -> keySeparator + currentKey)
                .orElse(currentKey);
    }

}
