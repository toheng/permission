package com.hengo.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Hengo.
 * 2018/4/6 21:35
 */
public class LevelUtil {
    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            // 有上级, 部门等级后加一, eg: 0.1  0.1.2
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
