package com.yq.yunmusic.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2017/10/13.
 */

public class RetrofitManager {

    private static RetrofitManager ourInstance = null;
    private Retrofit retrofit = null;
    private Retrofit retrofitNew = null;
    private static HttpService httpService;

    private static final String GANK_URL = "http://gank.io/api/";
    private final static String API_TING = "https://tingapi.ting.baidu.com/v1/restserver/";

    public static RetrofitManager getInstance() {
        if (null == ourInstance)
            ourInstance = new RetrofitManager();
        return ourInstance;
    }

    private RetrofitManager() {
    }

    /**
     * baseUrl 有变化时调用此方法
     *
     * @param newBaseUrl 新的 baseUrl
     * @return
     */
    public Retrofit getNewRetrofit(String newBaseUrl) {
        retrofitNew = new Retrofit.Builder()
                .baseUrl(newBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofitNew;
    }

    public static Retrofit getGankRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(GANK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getBannerRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_TING)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HttpService getGankHttpService() {
        return getGankRetrofit().create(HttpService.class);
    }

}
