package com.weweibuy.brms.utils;

import com.weweibuy.framework.common.core.model.constant.CommonConstant;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/13 23:10
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DroolsCollectionUtils {

    public static boolean containsAll(Object o, Object o2) {
        if (o == null) {
            return false;
        }
        if (o instanceof Collection) {
            if (o2 instanceof Collection) {
                return ((Collection) o).containsAll((Collection) o2);
            }
            return ((Collection) o).contains(o2);
        }
        return false;
    }

    public static boolean allMemberOf(Object o, Object o2) {
        if (o2 == null) {
            return false;
        }
        if (o2 instanceof Collection) {
            if (o instanceof Collection) {
                return ((Collection) o2).containsAll((Collection) o);
            }
            return ((Collection) o2).contains(o);
        }
        return false;
    }

    public static List<String> toList(String str) {
        if (StringUtils.isBlank(str)) {
            return Collections.emptyList();
        }
        return Arrays.stream(str.split(CommonConstant.COMMA_STR))
                .collect(Collectors.toList());
    }

}
