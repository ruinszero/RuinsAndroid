package com.ruins.android.base;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruinszero on 2017/3/31.
 * 将bean转换为map
 */

public class BaseBean {
    private Map<String, Object> params;

    /**
     * 将Bean转换成map
     */
    public Map<String,Object> beanToMap() {
        Class<?> clazz = this.getClass();
        //获取类的属性
        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return Collections.emptyMap();
        }
        params = new HashMap<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(this)!=null) {
                    params.put(field.getName(), String.valueOf(field.get(this)));
                }
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return params;
    }
}
