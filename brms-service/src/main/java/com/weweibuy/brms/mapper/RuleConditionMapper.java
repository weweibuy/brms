package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleConditionExample;
import com.weweibuy.brms.model.po.RuleCondition;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleConditionMapper {
    long countByExample(RuleConditionExample example);

    int deleteByExample(RuleConditionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleCondition record);

    int insertSelective(RuleCondition record);

    RuleCondition selectOneByExample(RuleConditionExample example);

    RuleCondition selectOneByExampleForUpdate(RuleConditionExample example);

    List<RuleCondition> selectByExampleForUpdate(RuleConditionExample example);

    List<RuleCondition> selectByExampleWithLimit(@Param("example") RuleConditionExample example, @Param("limit") Integer limit);

    List<RuleCondition> selectByExample(RuleConditionExample example);

    RuleCondition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleCondition record, @Param("example") RuleConditionExample example);

    int updateByExample(@Param("record") RuleCondition record, @Param("example") RuleConditionExample example);

    int updateByPrimaryKeySelective(RuleCondition record);

    int updateByPrimaryKey(RuleCondition record);
}