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

    int deleteByPrimaryKey(Long id);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectOneByExample(ModelExample example);

    Model selectOneByExampleForUpdate(ModelExample example);

    List<Model> selectByExampleForUpdate(ModelExample example);

    List<Model> selectByExampleWithLimit(@Param("example") ModelExample example, @Param("limit") Integer limit);

    List<Model> selectByExample(ModelExample example);

    Model selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") ModelExample example);

    int updateByExample(@Param("record") Model record, @Param("example") ModelExample example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}