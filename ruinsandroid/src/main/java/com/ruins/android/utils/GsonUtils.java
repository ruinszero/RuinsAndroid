package com.ruins.android.utils;

import com.google.gson.Gson;

/**
 * @author jihao
 * Gson 单例实现
 * 注意：如果该单例只适用于简单适用，如果使用了 GsonBulider，又采用了线程不安全的类（时间相关），不要使用单例。
 */
public class GsonUtils {
    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Gson getGson() {
        return GsonHolder.GSON;
    }

    private static class GsonHolder{
        private static final Gson GSON = new Gson();
    }
}
