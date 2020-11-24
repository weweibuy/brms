package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleSetModelExample;
import com.weweibuy.brms.model.po.RuleSetModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleSetModelMapper {
    long countByExample(RuleSetModelExample example);

    int deleteByExample(RuleSetModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleSetModel record);

    int insertSelective(RuleSetModel record);

    RuleSetModel selectOneByExample(RuleSetModelExample example);

    RuleSetModel selectOneByExampleForUpdate(RuleSetModelExample example);

    List<RuleSetModel> selectByExampleForUpdate(RuleSetModelExample example);

    List<RuleSetModel> selectByExampleWithLimit(@Param("example") RuleSetModelExample example, @Param("limit") Integer limit);

    List<RuleSetModel> selectByExample(RuleSetModelExample example);

    RuleSetModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleSetModel record, @Param("example") RuleSetModelExample example);

    int updateByExample(@Param("record") RuleSetModel record, @Param("example") RuleSetModelExample example);

    int updateByPrimaryKeySelective(RuleSetModel record);

    int updateByPrimaryKey(RuleSetModel record);
}