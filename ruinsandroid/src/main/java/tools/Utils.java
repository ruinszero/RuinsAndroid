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
package tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.reactivex.annotations.NonNull;

/**
 * Created by haowei on 2017/7/7.
 * Utils初始化相关
 */

public class Utils {

	@SuppressLint("StaticFieldLeak")
	private static Context context;

	private Utils() {
		throw new UnsupportedOperationException("u can't instantiate me...");
	}

	/**
	 * 初始化工具类
	 *
	 * @param context 上下文
	 */
	public static void init(@NonNull final Context context) {
		Utils.context = context.getApplicationContext();
	}

	/**
	 * 获取ApplicationContext
	 *
	 * @return ApplicationContext
	 */
	public static Context getContext() {
		if (context != null) return context;
		throw new NullPointerException("u should init first");
	}

	/**
	 * 获取应用版本号
	 *
	 * @param context Context
	 */
	public static String getVersionName(Context context) {
		PackageManager manager = context.getPackageManager();
		PackageInfo packageInfo;
		try {
			packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}
}
