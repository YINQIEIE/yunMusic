package com.yq.yunmusic.http;


import android.util.Log;

import com.yq.yunmusic.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * OkHttpClient管理类，用来获取 OkHttpClient 实例
 */
public class OkHttpClientManager {

    private static OkHttpClient client = null;
    private static OkHttpClient.Builder builder = null;

    private OkHttpClientManager() {
    }

    public synchronized static OkHttpClient getClient() {
        if (client == null) {
            if (builder == null) {
                builder = new OkHttpClient.Builder();
            }
            //okhttp日志打印
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new OkHttpLogger());
            if (BuildConfig.DEBUG)
                logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            else
                logInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            builder.addNetworkInterceptor(logInterceptor);
            client = builder.connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }

    /**
     * 日志打印类
     */
    private static class OkHttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.i("requestBody", message);
        }
    }

}