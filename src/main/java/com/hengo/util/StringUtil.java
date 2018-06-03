package com.hengo.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hengo.
 * @since 2018/6/2 19:40
 */
public class StringUtil {

    public static List<Integer> splitToListInt(String str) {
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        return strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
    }

}
