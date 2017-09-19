package com.niuka.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

public class ClassUtil {

    /**
     * 将对象转换为整数
     * 2016-9-22 12:13:32
     * lf
     * @param obj
     * @return
     */
    public static Integer toInteger(Object obj) {
        return Integer.valueOf(obj.toString());
    }

    /**
     * 将一个类查询方式加入map（属性值为int型时，0时不加入，
     * 属性值为String型或Long时为null和“”不加入）
     *
     */
    public static Map<String, Object> toMap(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (obj == null) {
            return null;
        }

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();

            if (getValueByFieldName(fieldName, obj) != null) {
                map.put(fieldName, getValueByFieldName(fieldName, obj));
            }
        }

        return map;
    }

    /**
     * 重写toString
     * lf
     * 2016-9-13 14:30:41
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return (obj == null)
               ? ""
               : obj.toString();
    }

    /**
     * 获取double
     * @param obj
     * @return
     */
    public static final Double getDouble(Object obj) {
        if (isEmpty(obj)) {
            return 0.0;
        }

        return Double.valueOf(obj.toString());
    }

    /**
     * 获取double
     * @param obj
     * @return
     */
    public static final Boolean getBoolean(Object obj) {
        if (isEmpty(obj)) {
            return false;
        }

        return Boolean.valueOf(obj.toString());
    }
    /**
     * Boolean
     * 2016-9-22 14:08:31
     * lf
     * @param map
     * @return
     */
    public static final Boolean getBoolean(Map<String, Object> map, String key) {
        if ((map == null) || map.isEmpty()) {
            return false;
        }

        return getBoolean(map.get(key));
    }
    /**
     * 获取Double
     * 2016-9-22 14:08:31
     * lf
     * @param map
     * @return
     */
    public static final Double getDouble(Map<String, Object> map, String key) {
        if ((map == null) || map.isEmpty()) {
            return 0.0;
        }

        return getDouble(map.get(key));
    }

    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        return StringUtils.isBlank(obj.toString());
    }

    /**
     * 获取Integer
     * 2016-9-22 12:13:32
     * lf
     * @param obj
     * @return
     */
    public static final Integer getInteger(Object obj) {
        if (isEmpty(obj)) {
            return 0;
        }

        return Integer.valueOf(obj.toString());
    }

    /**
     * 获取Integer
     * 2016-9-22 14:08:36
     * lf
     * @param map
     * @return
     */
    public static final Integer getInteger(Map<String, Object> map, String key) {
        if ((map == null) || map.isEmpty()) {
            return 0;
        }

        return getInteger(map.get(key));
    }

    /**
     * 获取long
     * 2016-9-22 12:13:32
     * lf
     * @param obj
     * @return
     */
    public static final Long getLong(Object obj) {
        if (isEmpty(obj)) {
            return 0L;
        }

        return Long.valueOf(obj.toString());
    }

    /**
     * 获取Long
     * 2016-9-22 14:08:27
     * lf
     * @param map
     * @return
     */
    public static final Long getLong(Map<String, Object> map, String key) {
        if ((map == null) || map.isEmpty()) {
            return 0L;
        }

        return getLong(map.get(key));
    }

    /**
     * 获取字符串
     * lf
     * 2016-9-22 12:13:25
     * @param obj
     * @return
     */
    public static String getString(Object obj) {
        return toString(obj);
    }

    /**
     * 获取String
     * 2016-9-22 14:08:31
     * lf
     * @param map
     * @return
     */
    public static final String getString(Map<String, Object> map, String key) {
        if ((map == null) || map.isEmpty()) {
            return "";
        }

        return getString(map.get(key));
    }


    /**
     * 根据属性名获取该类此属性的值
     * @param fieldName
     * @param object
     * @return
     */
    private static Object getValueByFieldName(String fieldName, Object object) {
        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String getter      = "get" + firstLetter + fieldName.substring(1);

        try {
            Method method = object.getClass().getMethod(getter);
            Object value  = method.invoke(object);

            return value;
        } catch (Exception e) {
            return null;
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
