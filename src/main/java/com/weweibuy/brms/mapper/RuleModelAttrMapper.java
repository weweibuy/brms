package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleModelAttrExample;
import com.weweibuy.brms.model.po.RuleModelAttr;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleModelAttrMapper {
    long countByExample(RuleModelAttrExample example);

    int deleteByExample(RuleModelAttrExample example);

    int insert(RuleModelAttr record);

    int insertSelective(RuleModelAttr record);

    RuleModelAttr selectOneByExample(RuleModelAttrExample example);

    RuleModelAttr selectOneByExampleForUpdate(RuleModelAttrExample example);

    List<RuleModelAttr> selectByExampleForUpdate(RuleModelAttrExample example);

    List<RuleModelAttr> selectByExample(RuleModelAttrExample example);

    int updateByExampleSelective(@Param("record") RuleModelAttr record, @Param("example") RuleModelAttrExample example);

    int updateByExample(@Param("record") RuleModelAttr record, @Param("example") RuleModelAttrExample example);
}