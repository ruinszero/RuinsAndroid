package com.ruins.android.utils.ui;

import com.google.android.material.navigation.NavigationView;

/**
 * Created by Ruins on 2017/8/7.
 * @author Ruins
 */

public class NavigationViewUtils {
    private NavigationViewUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 让icon显示自己颜色
     * @param navigationView
     */
    public static void setNavIconColor(NavigationView navigationView) {
        navigationView.setItemIconTintList(null);
    }
}
