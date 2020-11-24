package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleSetModelMapper;
import com.weweibuy.brms.model.example.RuleSetModelExample;
import com.weweibuy.brms.model.po.RuleSetModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/11/8 21:35
 **/
@Repository
@RequiredArgsConstructor
public class RuleSetModelRepository {

    private final RuleSetModelMapper ruleSetModelMapper;


    public List<RuleSetModel> selectRuleSetModel(String ruleSetKey) {
        return ruleSetModelMapper.selectByExample(RuleSetModelExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andRuleSetKeyEqualTo(ruleSetKey)
                .example());
    }


}
