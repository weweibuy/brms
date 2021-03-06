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

    int deleteByPrimaryKey(Long id);

    int insert(ModelAttr record);

    int insertSelective(ModelAttr record);

    ModelAttr selectOneByExample(ModelAttrExample example);

    ModelAttr selectOneByExampleForUpdate(ModelAttrExample example);

    List<ModelAttr> selectByExampleForUpdate(ModelAttrExample example);

    List<ModelAttr> selectByExampleWithLimit(@Param("example") ModelAttrExample example, @Param("limit") Integer limit);

    List<ModelAttr> selectByExample(ModelAttrExample example);

    ModelAttr selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModelAttr record, @Param("example") ModelAttrExample example);

    int updateByExample(@Param("record") ModelAttr record, @Param("example") ModelAttrExample example);

    int updateByPrimaryKeySelective(ModelAttr record);

    int updateByPrimaryKey(ModelAttr record);
}