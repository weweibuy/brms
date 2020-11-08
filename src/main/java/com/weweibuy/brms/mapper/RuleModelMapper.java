package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleModelExample;
import com.weweibuy.brms.model.po.RuleModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleModelMapper {
    long countByExample(RuleModelExample example);

    int deleteByExample(RuleModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleModel record);

    int insertSelective(RuleModel record);

    RuleModel selectOneByExample(RuleModelExample example);

    RuleModel selectOneByExampleForUpdate(RuleModelExample example);

    List<RuleModel> selectByExampleForUpdate(RuleModelExample example);

    List<RuleModel> selectByExample(RuleModelExample example);

    RuleModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleModel record, @Param("example") RuleModelExample example);

    int updateByExample(@Param("record") RuleModel record, @Param("example") RuleModelExample example);

    int updateByPrimaryKeySelective(RuleModel record);

    int updateByPrimaryKey(RuleModel record);
}