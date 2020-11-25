package com.weweibuy.brms.support;

import com.weweibuy.brms.model.po.ModelAttr;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author durenhao
 * @date 2020/11/25 21:00
 **/
public class RuleModelHelper {


    /**
     * 对不存在的属性赋空值
     *
     * @param inputModel
     * @param modelAttrList
     * @return
     */
    public static void fixModel(Map<String, Object> inputModel, List<ModelAttr> modelAttrList) {
        Set<String> inputModelKeySet = inputModel.keySet();
        modelAttrList.stream()
                .map(ModelAttr::getAttrName)
                .filter(name -> !inputModelKeySet.contains(name))
                .forEach(name -> inputModel.put(name, null));
    }


}
