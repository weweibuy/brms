package com.weweibuy.brms.api.model.dto.req;

import com.weweibuy.framework.common.core.model.dto.CommonPageRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/7/25 16:40
 **/
@Data
public class RuleHitLogReqDTO extends CommonPageRequest {

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

    private LocalDateTime createTimeFrom;

    private LocalDateTime createTimeTo;




}
