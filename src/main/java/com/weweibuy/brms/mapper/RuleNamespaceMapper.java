package com.weweibuy.brms.mapper;

import com.weweibuy.brms.model.example.RuleNamespaceExample;
import com.weweibuy.brms.model.po.RuleNamespace;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RuleNamespaceMapper {
    long countByExample(RuleNamespaceExample example);

    int deleteByExample(RuleNamespaceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RuleNamespace record);

    int insertSelective(RuleNamespace record);

    RuleNamespace selectOneByExample(RuleNamespaceExample example);

    RuleNamespace selectOneByExampleForUpdate(RuleNamespaceExample example);

    List<RuleNamespace> selectByExampleForUpdate(RuleNamespaceExample example);

    List<RuleNamespace> selectByExample(RuleNamespaceExample example);

    RuleNamespace selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RuleNamespace record, @Param("example") RuleNamespaceExample example);

    int updateByExample(@Param("record") RuleNamespace record, @Param("example") RuleNamespaceExample example);

    int updateByPrimaryKeySelective(RuleNamespace record);

    int updateByPrimaryKey(RuleNamespace record);
}