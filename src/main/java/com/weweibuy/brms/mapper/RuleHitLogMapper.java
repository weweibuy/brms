package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleHitLogExample;
import com.weweibuy.brms.model.po.RuleHitLog;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleHitLogMapper {
    long countByExample(RuleHitLogExample example);

    int deleteByExample(RuleHitLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleHitLog record);

    int insertSelective(RuleHitLog record);

    RuleHitLog selectOneByExample(RuleHitLogExample example);

    RuleHitLog selectOneByExampleForUpdate(RuleHitLogExample example);

    List<RuleHitLog> selectByExampleForUpdate(RuleHitLogExample example);

    List<RuleHitLog> selectByExample(RuleHitLogExample example);

    RuleHitLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleHitLog record, @Param("example") RuleHitLogExample example);

    int updateByExample(@Param("record") RuleHitLog record, @Param("example") RuleHitLogExample example);

    int updateByPrimaryKeySelective(RuleHitLog record);

    int updateByPrimaryKey(RuleHitLog record);
}