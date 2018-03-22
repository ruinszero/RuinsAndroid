package com.ruins.android.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jihao on 11/8/2017.
 *
 * @author jihao
 */

public class CollectionUtil {
    /**
     * 返回取出collection2在collection1中的相对补集
     * @param collection 集合1
     * @param collection2 集合2
     * @return
     */
    public static List<? extends BeanContain> getComplement(List<? extends BeanContain> collection, List<? extends BeanContain> collection2) {
        List<BeanContain> collection1 = new ArrayList<>(collection);
        for (BeanContain bean : collection) {
            for (BeanContain bizRenwu : collection2) {
                if (bizRenwu.equals(bean)) {
                    collection1.remove(bean);
                    break;
                }
            }
        }
        return collection1;
    }
}
