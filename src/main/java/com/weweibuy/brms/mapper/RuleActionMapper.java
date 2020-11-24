package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleActionExample;
import com.weweibuy.brms.model.po.RuleAction;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleActionMapper {
    long countByExample(RuleActionExample example);

    int deleteByExample(RuleActionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleAction record);

    int insertSelective(RuleAction record);

    RuleAction selectOneByExample(RuleActionExample example);

    RuleAction selectOneByExampleForUpdate(RuleActionExample example);

    List<RuleAction> selectByExampleForUpdate(RuleActionExample example);

    List<RuleAction> selectByExampleWithLimit(@Param("example") RuleActionExample example, @Param("limit") Integer limit);

    List<RuleAction> selectByExample(RuleActionExample example);

    RuleAction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleAction record, @Param("example") RuleActionExample example);

    int updateByExample(@Param("record") RuleAction record, @Param("example") RuleActionExample example);

    int updateByPrimaryKeySelective(RuleAction record);

    int updateByPrimaryKey(RuleAction record);
}