package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleSetExample;
import com.weweibuy.brms.model.po.RuleSet;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleSetMapper {
    long countByExample(RuleSetExample example);

    int deleteByExample(RuleSetExample example);

    int insert(RuleSet record);

    int insertSelective(RuleSet record);

    RuleSet selectOneByExample(RuleSetExample example);

    RuleSet selectOneByExampleForUpdate(RuleSetExample example);

    List<RuleSet> selectByExampleForUpdate(RuleSetExample example);

    List<RuleSet> selectByExample(RuleSetExample example);

    int updateByExampleSelective(@Param("record") RuleSet record, @Param("example") RuleSetExample example);

    int updateByExample(@Param("record") RuleSet record, @Param("example") RuleSetExample example);
}