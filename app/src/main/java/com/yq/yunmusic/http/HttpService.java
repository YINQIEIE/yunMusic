package com.yq.yunmusic.http;

import com.yq.yunmusic.http.response.GankBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yinqi on 2017/11/2.
 */

public interface HttpService {

    @GET("ting?from=android&version=5.8.1.0&channel=ppzs&operator=3&method=baidu.ting.plaza.index&cuid=89CF1E1A06826F9AB95A34DC0F6AAA14")
    Call getBannerUrls();
    /**
     * 每日数据： http://gank.io/api/day/年/月/日
     * eg:http://gank.io/api/day/2015/08/06
     */
    @GET("day/{year}/{month}/{day}")
    Call<GankBean> getGankIoDay(@Path("year") int year, @Path("month") int month, @Path("day") int day);

}
