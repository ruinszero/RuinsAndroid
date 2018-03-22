package com.ruins.android.http;


import com.ruins.android.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * HttpClient 类
 * @author Ruins
 */
public class HttpClient {
    private volatile static HttpClient httpClient;
    private Retrofit retrofit;

    /**
     * 获取HttpClient
     * @param baseUrl  URL
     */
    public static HttpClient getInstance(String baseUrl){
        if (httpClient==null){
            synchronized (HttpClient.class){
                if (httpClient==null){
                    httpClient=new HttpClient(baseUrl);
                }
            }
        }
        return httpClient;
    }

    private HttpClient(String baseUrl){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        if (BuildConfig.DEBUG){
            //Log信息拦截器
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置Log
            builder.addInterceptor(interceptor);
        }

        OkHttpClient client = builder
                //设置超时时间
                .connectTimeout(30, TimeUnit.SECONDS)
                //设置读超时时间
                .readTimeout(30, TimeUnit.SECONDS)
                //设置写超时时间
                .writeTimeout(30, TimeUnit.SECONDS)
                //是否错误重连
                .retryOnConnectionFailure(true)
                .build();

        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T createService(Class<T> tClass){
        return retrofit.create(tClass);
    }
}