package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleExample;
import com.weweibuy.brms.model.po.Rule;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleMapper {
    long countByExample(RuleExample example);

    int deleteByExample(RuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectOneByExample(RuleExample example);

    Rule selectOneByExampleForUpdate(RuleExample example);

    List<Rule> selectByExampleForUpdate(RuleExample example);

    List<Rule> selectByExample(RuleExample example);

    Rule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Rule record, @Param("example") RuleExample example);

    int updateByExample(@Param("record") Rule record, @Param("example") RuleExample example);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);
}