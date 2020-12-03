package com.weweibuy.brms.model.event;

import com.weweibuy.brms.model.po.RuleHitLog;
import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import lombok.Builder;
import lombok.Data;

/**
 * 规则命中事件
 *
 * @author durenhao
 * @date 2020/11/14 18:24
 **/
@Data
@Builder
public class RuleHitLogEvent {

    /**
     * 流水号
     */
    private String requestNo;

    /**
     * 规则集key(package)
     */
    private String ruleSetKey;

    /**
     * 议程组
     */
    private String agendaGroup;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 输入模型(Json)
     */
    private String inputModel;

    /**
     * 输出模型(Json)
     */
    private String outputModel;


    public RuleHitLog toRuleHitLog() {
        return BeanCopyUtils.copy(this, RuleHitLog.class);
    }

}
