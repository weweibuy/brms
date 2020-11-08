package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.ModelExample;
import com.weweibuy.brms.model.po.Model;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ModelMapper {
    long countByExample(ModelExample example);

    int deleteByExample(ModelExample example);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectOneByExample(ModelExample example);

    Model selectOneByExampleForUpdate(ModelExample example);

    List<Model> selectByExampleForUpdate(ModelExample example);

    List<Model> selectByExample(ModelExample example);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") ModelExample example);

    int updateByExample(@Param("record") Model record, @Param("example") ModelExample example);
}