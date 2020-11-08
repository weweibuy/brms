package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.ModelAttrExample;
import com.weweibuy.brms.model.po.ModelAttr;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ModelAttrMapper {
    long countByExample(ModelAttrExample example);

    int deleteByExample(ModelAttrExample example);

    int insert(ModelAttr record);

    int insertSelective(ModelAttr record);

    ModelAttr selectOneByExample(ModelAttrExample example);

    ModelAttr selectOneByExampleForUpdate(ModelAttrExample example);

    List<ModelAttr> selectByExampleForUpdate(ModelAttrExample example);

    List<ModelAttr> selectByExample(ModelAttrExample example);

    int updateByExampleSelective(@Param("record") ModelAttr record, @Param("example") ModelAttrExample example);

    int updateByExample(@Param("record") ModelAttr record, @Param("example") ModelAttrExample example);
}