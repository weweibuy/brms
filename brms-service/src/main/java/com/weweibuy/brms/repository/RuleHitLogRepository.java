package com.weweibuy.brms.repository;

import com.weweibuy.brms.mapper.RuleHitLogMapper;
import com.weweibuy.brms.model.example.RuleHitLogExample;
import com.weweibuy.brms.model.po.RuleHitLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/11/14 20:05
 **/
@Repository
@RequiredArgsConstructor
public class RuleHitLogRepository {

    private final RuleHitLogMapper ruleHitLogMapper;

    public int insert(RuleHitLog ruleHitLog) {
        return ruleHitLogMapper.insertSelective(ruleHitLog);
    }


    public List<RuleHitLog> select(RuleHitLogExample ruleHitLogExample) {
        return ruleHitLogMapper.selectByExample(ruleHitLogExample);
    }
}
