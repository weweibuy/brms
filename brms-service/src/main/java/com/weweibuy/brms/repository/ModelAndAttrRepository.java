package com.weweibuy.brms.repository;

import com.weweibuy.brms.model.po.Model;
import com.weweibuy.brms.model.po.ModelAttr;

import java.util.List;
import java.util.Optional;

/**
 * 模型与属性仓库
 *
 * @author durenhao
 * @date 2020/11/25 20:44
 **/
public interface ModelAndAttrRepository {

    /**
     * 查询模型
     *
     * @param modelKey
     * @return
     */
    Optional<Model> selectModel(String modelKey);


    /**
     * 查询模型属性
     *
     * @param modelKey
     * @return
     */
    List<ModelAttr> selectModelAttrByModelKey(String modelKey);


    /**
     * 查询模型属性
     *
     * @param modelKey
     * @param attrName
     * @return
     */
    Optional<ModelAttr> selectModelAttr(String modelKey, String attrName);


}
