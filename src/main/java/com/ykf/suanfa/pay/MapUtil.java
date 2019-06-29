/*
 * Copyright (c) 2016 Xiaokaxiu. All rights reserved.
 */
package com.ykf.suanfa.pay;


import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class MapUtil {

    public static String getValue(Map map, Object key) {
        if (map != null) {
            Object answer = map.get(key);
            if (answer != null) {
                return answer.toString();
            }
        }

        return null;
    }


    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }



    /**
     * 连接map各key value，示例： key1=value1&key2=value2
     * @param map
     * @return
     */
    public static String concat(Map<String, ?> map) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet<String> keys = new TreeSet<>(map.keySet());
        for (String key : keys) {
            if (map.get(key) != null) {
                stringBuilder.append(key + "=" + map.get(key) + "&");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    /**
     * 连接map各key value，示例： key1=value1&key2=value2(如果值为空，不参与签名)
     * @param map
     * @return
     */
    public static String concatNotEmpty(Map<String, ?> map) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet<String> keys = new TreeSet<>(map.keySet());
        for (String key : keys) {
            if (!StringUtils.isEmpty(String.valueOf(map.get(key)))) {
                stringBuilder.append(key + "=" + map.get(key) + "&");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    /**
     * 连接map各key value，示例： key1=value1&key2=value2
     * @param map
     * @return
     */
    public static String concatForTencent(Map<String, ?> map) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeSet<String> keys = new TreeSet<>(map.keySet());
        for (String key : keys) {
            if (map.get(key) != null) {
                stringBuilder.append(key + "" + map.get(key) + "");
            }
        }
        return stringBuilder.toString();
    }

}

class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

