package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleSetModelMapper;
import com.weweibuy.brms.api.model.eum.ModelTypeEum;
import com.weweibuy.brms.model.example.RuleSetModelExample;
import com.weweibuy.brms.model.po.RuleSetModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/8 21:35
 **/
@Repository
@RequiredArgsConstructor
public class JdbcRuleSetModelRepositoryImpl implements RuleSetModelRepository {

    private final RuleSetModelMapper ruleSetModelMapper;


    public List<RuleSetModel> selectRuleSetModel(String ruleSetKey) {
        return ruleSetModelMapper.selectByExample(RuleSetModelExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .example());
    }

    @Override
    public Optional<RuleSetModel> selectRuleSetModel(String ruleSetKey, ModelTypeEum modelType) {
        return Optional.ofNullable(ruleSetModelMapper.selectOneByExample(RuleSetModelExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .andModelTypeEqualTo(modelType.toString())
                .example()));
    }


}
