package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleSetModelMapper;
import com.weweibuy.brms.model.example.RuleSetModelExample;
import com.weweibuy.brms.model.po.RuleSetModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/8 21:35
 **/
@Repository
@RequiredArgsConstructor
public class RuleSetModelRepository {

    private final RuleSetModelMapper ruleSetModelMapper;


    public Optional<RuleSetModel> selectRuleSetModel(String ruleSetKey) {
        return Optional.ofNullable(ruleSetModelMapper.selectOneByExample(RuleSetModelExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .example()));
    }


}
