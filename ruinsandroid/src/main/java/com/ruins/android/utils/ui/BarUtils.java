/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ruins.android.utils.ui;

import android.app.Activity;
import android.view.WindowManager;
import io.reactivex.annotations.NonNull;

/**
 * Created by haowei on 2017/7/6.
 * Bar相关工具类
 * 本工具类参考 https://github.com/Blankj/AndroidUtilCode 实现
 */

public class BarUtils {

	/**
	 * 设置透明状态栏（api大于19方可使用）
	 * <p>可在Activity的onCreat()中调用</p>
	 * <p>需在顶部控件布局中加入以下属性让内容出现在状态栏之下</p>
	 * <p>android:clipToPadding="true"</p>
	 * <p>android:fitsSystemWindows="true"</p>
	 *
	 * @param activity activity
	 */
	public static void setTransparentStatusBar(@NonNull final Activity activity) {
		//透明状态栏
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	}

	/**
	 * 设置透明导航栏（api大于19方可使用）
	 * <p>可在Activity的onCreat()中调用</p>
	 * <p>需在顶部控件布局中加入以下属性让内容出现在状态栏之下</p>
	 * <p>android:clipToPadding="true"</p>
	 * <p>android:fitsSystemWindows="true"</p>
	 *
	 * @param activity activity
	 */
	public static void setTransparentNavigationBar(@NonNull Activity activity) {
		//透明导航栏
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
	}

	/**
	 * 设置不透明状态栏（api大于19方可使用）
	 * <p>可在Activity的onCreat()中调用</p>
	 * <p>需在顶部控件布局中加入以下属性让内容出现在状态栏之下</p>
	 * <p>android:clipToPadding="true"</p>
	 * <p>android:fitsSystemWindows="true"</p>
	 *
	 * @param activity activity
	 */
	public static void setNoTranasparentStatusBar(@NonNull Activity activity) {
		//不透明状态栏
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SPLIT_TOUCH);
	}

	/**
	 * 设置不透明导航栏（api大于19方可使用）
	 * <p>可在Activity的onCreat()中调用</p>
	 * <p>需在顶部控件布局中加入以下属性让内容出现在状态栏之下</p>
	 * <p>android:clipToPadding="true"</p>
	 * <p>android:fitsSystemWindows="true"</p>
	 *
	 * @param activity activity
	 */
	public static void setNoTranasparentNavigationBar(@NonNull Activity activity) {
		//不透明导航栏
		activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
	}
}
