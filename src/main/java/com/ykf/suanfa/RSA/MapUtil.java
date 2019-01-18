/*
 * Copyright (c) 2016 Xiaokaxiu. All rights reserved.
 */
package com.ykf.suanfa.RSA;

import net.sf.json.JSONObject;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class MapUtil {

    /**
     * 将json格式的字符串解析成Map对象 <li>
     * json格式：{"name":"admin","retries":"3fff","testname"
     * :"ddd","testretries":"fffffffff"}
     */
    public static HashMap<String, Integer> toHashMap(Object object) {
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        // 将json字符串转换成jsonObject
        if ("null".equals(String.valueOf(object)) ||
                !String.valueOf(object).startsWith("{")
                || !String.valueOf(object).endsWith("}")) {
            return data;
        }
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext()) {
            String key = String.valueOf(it.next());
            Integer value = 0;
            if (jsonObject.get(key) != null && !jsonObject.get(key).equals("")) {
                if (jsonObject.get(key) instanceof Integer) {
                    value = (Integer) jsonObject.get(key);
                } else if (jsonObject.get(key) instanceof String) {
                    value = Integer.parseInt((String) jsonObject.get(key));
                }
            }
            data.put(key, value);
        }
        return data;
    }

    public static TreeMap<String, String> toTreeMap(Object object) {
        TreeMap<String, String> data = new TreeMap<>();
        JSONObject jsonObject = JSONObject.fromObject(object);
        if (Objects.equals(null, jsonObject)) {
            return data;
        }
        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            String key = String.valueOf(it.next());
            if (jsonObject.get(key) == null || jsonObject.get(key).equals("")) {
                continue;
            }
            if (jsonObject.get(key) instanceof String) {
                String value = jsonObject.getString(key);
                data.put(key, value);
            }
        }
        return data;
    }

    public static <T> T map2Obj(Map<String, Object> map, Class<T> clz) throws Exception {
        if (map == null)
            return null;
        Set<String> s = map.keySet(); //所有的key  field
        T obj = clz.newInstance();
        Field[] fields = clz.getDeclaredFields();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            if (property.getName() == null) { //  需要反射的key
                continue;
            }
            if (!s.contains(property.getName().toLowerCase())) {
                continue;
            }

            Method setter = property.getWriteMethod();
            if (setter != null) {
                Class[] clazz = setter.getParameterTypes();
                String type = clazz[0].getName();// type = java.Long

                if (type.equals("java.lang.Short") || type.equals("short")) {
                    setter.invoke(obj, Short.parseShort(map.get(property.getName().toLowerCase()).toString()));
                } else if (type.equals("java.lang.Integer") || type.equals("int")) {
                    setter.invoke(obj, Integer.parseInt(map.get(property.getName().toLowerCase()).toString()));
                } else if (type.equals("java.lang.Long") || type.equals("long")) {
                    setter.invoke(obj, Long.parseLong(map.get(property.getName().toLowerCase()).toString()));
                } else if (type.equals("java.lang.Boolean") || type.equals("boolean")) {
                    setter.invoke(obj, Boolean.parseBoolean(map.get(property.getName().toLowerCase()).toString()));
                } else if (type.equals("java.lang.Byte") || type.equals("byte")) {
                    setter.invoke(obj, Byte.parseByte(map.get(property.getName().toLowerCase()).toString()));
                } else if (type.equals("java.lang.Double") || type.equals("double")) {
                    setter.invoke(obj, Double.parseDouble(map.get(property.getName().toLowerCase()).toString()));
                } else if (type.equals("java.lang.Float") || type.equals("float")) {
                    setter.invoke(obj, Float.parseFloat(map.get(property.getName().toLowerCase()).toString()));
                } else {
                    setter.invoke(obj, map.get(property.getName().toLowerCase()).toString());
                }
            }
        }
        return obj;
    }

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
     * 实体对象转成Map
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}

class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

