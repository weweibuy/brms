package com.weweibuy.brms.support;

import com.weweibuy.brms.model.po.ModelAttr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 条件构建上下文
 *
 * @author durenhao
 * @date 2020/11/29 13:35
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConditionBuildContext {

    private Integer maxIndex;

    private Integer conditionIndex;

    private List<String> paramList;

    private String[] oriConditionAttrArr;

    private String oriConditionAttrName;

    private ModelAttr modelAttr;

    private Boolean nesting;


}
