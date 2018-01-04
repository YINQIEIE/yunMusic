package com.yq.yunmusic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.EveryDayRecAdapter;
import com.yq.yunmusic.base.BaseLoadFragment;
import com.yq.yunmusic.http.RetrofitManager;
import com.yq.yunmusic.http.response.GankBean;
import com.yq.yunmusic.utils.ConstantsImageUrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/3.
 */

public class EveryDayRecFragment extends BaseLoadFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    List<List<GankBean.ResultBean>> data;
    private EveryDayRecAdapter gankAdapter;
    private List<String> orderList = Arrays.asList("Android", "福利", "iOS", "休息视频", "瞎推荐", "前端");

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_every_day;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        data = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        gankAdapter = new EveryDayRecAdapter(getActivity(), data);
        gankAdapter.addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.header_item_everyday, null));
        rv.setAdapter(gankAdapter);

    }

    @Override
    protected void getData() {
        getContent();
        Call bannerCall = RetrofitManager.getGankHttpService().getBannerUrls();
        bannerCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                String body = (String) response.body();
                log(body);
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }

    /**
     * 获取各种资讯
     */
    private void getContent() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        day = 2;
        Call<GankBean> gankCall = RetrofitManager.getGankHttpService().getGankIoDay(year, month, day);
        gankCall.enqueue(new Callback<GankBean>() {
            @Override
            public void onResponse(Call<GankBean> call, Response<GankBean> response) {
                log("onResponse" + response.body().toString());
                GankBean gankBean = response.body();
                List<String> category = gankBean.getCategory();
                Map<String, List<GankBean.ResultBean>> map = gankBean.getResults();
                String groupName;
                data.clear();
                for (int i = 0; i < orderList.size(); i++) {
                    groupName = orderList.get(i);
                    List<GankBean.ResultBean> list = map.get(groupName);
                    addUrlList(data, list, groupName);
                    log("group is " + groupName + "size is " + list.size());
                    for (int j = 0; j < list.size(); j++) {
                        log(list.get(j).toString());
                    }
                }
                gankAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GankBean> call, Throwable t) {
                log("failure");
            }
        });
    }


    // subList没有实现序列化！缓存时会出错！
    private void addUrlList(List<List<GankBean.ResultBean>> lists, List<GankBean.ResultBean> arrayList, String typeTitle) {
        // title
        log("addUrlList title >>> " + typeTitle);
        GankBean.ResultBean bean = new GankBean.ResultBean();
        bean.setName(typeTitle);
        ArrayList<GankBean.ResultBean> androidBeen = new ArrayList<>();
        androidBeen.add(bean);
        lists.add(androidBeen);

        int androidSize = arrayList.size();

        if (androidSize > 0 && androidSize < 4) {

            lists.add(addUrlList(arrayList, androidSize));
        } else if (androidSize >= 4) {

            ArrayList<GankBean.ResultBean> list1 = new ArrayList<>();
            ArrayList<GankBean.ResultBean> list2 = new ArrayList<>();

            for (int i = 0; i < androidSize; i++) {
                if (i < 3) {
                    list1.add(getAndroidBean(arrayList, i, androidSize));
                } else if (i < 6) {
                    list2.add(getAndroidBean(arrayList, i, androidSize));
                }
            }
            lists.add(list1);
            lists.add(list2);
        }
    }

    private List<GankBean.ResultBean> addUrlList(List<GankBean.ResultBean> arrayList, int androidSize) {
        List<GankBean.ResultBean> tempList = new ArrayList<>();
        for (int i = 0; i < androidSize; i++) {
            GankBean.ResultBean androidBean = new GankBean.ResultBean();
            // 标题
            androidBean.setDesc(arrayList.get(i).getDesc());
            // 类型
            androidBean.setType(arrayList.get(i).getType());
            // 跳转链接
            androidBean.setUrl(arrayList.get(i).getUrl());
//            DebugUtil.error("---androidSize:  " + androidSize);
            // 随机图的url
            if (androidSize == 1) {
                androidBean.setImageUrl(ConstantsImageUrl.HOME_ONE_URLS[getRandom(1)]);//一图
            } else if (androidSize == 2) {
                androidBean.setImageUrl(ConstantsImageUrl.HOME_TWO_URLS[getRandom(2)]);//两图
            } else if (androidSize == 3) {
                androidBean.setImageUrl(ConstantsImageUrl.HOME_SIX_URLS[getRandom(3)]);//三图
            }
            tempList.add(androidBean);
        }
        return tempList;
    }

    private GankBean.ResultBean getAndroidBean(List<GankBean.ResultBean> arrayList, int i, int androidSize) {

        GankBean.ResultBean resultBean = new GankBean.ResultBean();
        // 标题
        resultBean.setDesc(arrayList.get(i).getDesc());
        // 类型
        resultBean.setType(arrayList.get(i).getType());
        // 跳转链接
        resultBean.setUrl(arrayList.get(i).getUrl());
        // 随机图的url
        if (i < 3) {
            resultBean.setImageUrl(ConstantsImageUrl.HOME_SIX_URLS[getRandom(3)]);//三小图
        } else if (androidSize == 4) {
            resultBean.setImageUrl(ConstantsImageUrl.HOME_ONE_URLS[getRandom(1)]);//一图
        } else if (androidSize == 5) {
            resultBean.setImageUrl(ConstantsImageUrl.HOME_TWO_URLS[getRandom(2)]);//两图
        } else if (androidSize >= 6) {
            resultBean.setImageUrl(ConstantsImageUrl.HOME_SIX_URLS[getRandom(3)]);//三小图
        }
        return resultBean;
    }

    /**
     * 取不同的随机图，在每次网络请求时重置
     */
    private static final String HOME_ONE = "home_one";
    private static final String HOME_TWO = "home_two";
    private static final String HOME_SIX = "home_six";

    private int getRandom(int type) {
        int urlLength = 0;
        if (type == 1) {
            urlLength = ConstantsImageUrl.HOME_ONE_URLS.length;
        } else if (type == 2) {
            urlLength = ConstantsImageUrl.HOME_TWO_URLS.length;
        } else if (type == 3) {
            urlLength = ConstantsImageUrl.HOME_SIX_URLS.length;
        }

        Random random = new Random();
        int randomInt = random.nextInt(urlLength);
        return randomInt;
    }

}
