package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.ModelAttrMapper;
import com.weweibuy.brms.mapper.ModelMapper;
import com.weweibuy.brms.model.example.ModelAttrExample;
import com.weweibuy.brms.model.example.ModelExample;
import com.weweibuy.brms.model.po.Model;
import com.weweibuy.brms.model.po.ModelAttr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/8 21:35
 **/
@Repository
@RequiredArgsConstructor
public class ModelAndAttrRepository {

    private final ModelMapper modelMapper;

    private final ModelAttrMapper modelAttrMapper;


    public Optional<Model> selectModel(String modelKey) {
        return Optional.ofNullable(modelMapper.selectOneByExample(ModelExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andModelKeyEqualTo(modelKey)
                .example()));
    }


    public List<ModelAttr> selectModelAttrByModelKey(String modelKey) {
        return modelAttrMapper.selectByExample(ModelAttrExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andModelKeyEqualTo(modelKey)
                .example());
    }


    public Optional<ModelAttr> selectModelAttr(String modelKey, String attrName) {
        return Optional.ofNullable(modelAttrMapper.selectOneByExample(ModelAttrExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andModelKeyEqualTo(modelKey)
                .andAttrNameEqualTo(attrName)
                .example()));
    }

}
