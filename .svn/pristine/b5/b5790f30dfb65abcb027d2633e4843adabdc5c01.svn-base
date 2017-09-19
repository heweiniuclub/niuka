package com.niuka.common.model;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hewei on 2016/8/30.
 */
public class AbstractBaseFactory {

    /**
     * 对象转换
     *
     * @param object
     * @return
     */
    public static ExtendMap<String, Object> createAbstractBean(Object object) {
        if (object == null) {
            return null;
        }

        ExtendMap<String, Object> paramMap = new ExtendMap<String, Object>(transBeanMap(object));

        if (paramMap != null) {
            return paramMap;
        }

        return null;
    }

    /**
     * 对象转换为map
     *
     * @param object
     * @return
     */
    public static ExtendMap<String, Object> createMap(Object object) {
        ExtendMap<String, Object> map = new ExtendMap();

        if (object == null) {
            return map;
        }

        map.putAll(transBeanMap(object));

        return map;
    }

    /**
     * 实体转map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> transBeanMap(Object obj) {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        try {
            BeanInfo             beanInfo            = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {

                    // 得到p     roperty对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value  = getter.invoke(obj);

                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }

        return map;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
