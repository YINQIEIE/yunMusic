package com.yq.yunmusic.http;

import com.yq.yunmusic.http.response.BannerBean;
import com.yq.yunmusic.http.response.GankBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by yinqi on 2017/11/2.
 */

public interface HttpService {

    //    @Headers("User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36")
    @Headers("User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64)")
    @GET("ting?from=android&version=2.4.0&method=baidu.ting.plaza.getFocusPic&format=json&limit=111")
//    @GET("ting?from=android&version=5.8.1.0&channel=ppzs&operator=3&method=baidu.ting.plaza.index&cuid=89CF1E1A06826F9AB95A34DC0F6AAA14")
    Call<BannerBean> getBannerUrls();

    /**
     * 每日数据： http://gank.io/api/day/年/月/日
     * eg:http://gank.io/api/day/2015/08/06
     */
    @GET("day/{year}/{month}/{day}")
    Call<GankBean<Map<String, List<GankBean.ResultBean>>>> getGankIoDay(@Path("year") int year, @Path("month") int month, @Path("day") int day);

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/Android/10/1
     */
    @GET("data/{type}/{per_page}/{page}")
    Call<GankBean<List<GankBean.ResultBean>>> getGankPhotos(@Path("type") String type, @Path("page") int page, @Path("per_page") int per_page);

}
