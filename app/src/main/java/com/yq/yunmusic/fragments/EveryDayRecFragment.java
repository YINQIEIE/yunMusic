package com.yq.yunmusic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.EveryDayRecAdapter;
import com.yq.yunmusic.base.BaseLoadFragment;
import com.yq.yunmusic.http.RetrofitManager;
import com.yq.yunmusic.http.response.GankBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_every_day;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        log("EveryDayRecFragment");
        data = new ArrayList<>();
//        gankAdapter = new EveryDayRecAdapter(getActivity(), data);
//        rv.setAdapter(gankAdapter);
    }

    @Override
    protected void getData() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        day = 2;
        log("time>>> " + year + ">>>" + month + ">>>" + day);
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
                for (int i = 0; i < category.size(); i++) {
                    groupName = category.get(i);
                    data.add(Arrays.asList(new GankBean.ResultBean(groupName)));
                    List<GankBean.ResultBean> list = map.get(groupName);
                    data.add(list);
//                    list.get(0).setName(groupName);
                    log("group is " + category.get(i));
                    for (int j = 0; j < list.size(); j++) {
                        log(list.get(j).toString());
                    }
                }
                gankAdapter = new EveryDayRecAdapter(getActivity(), data);
                rv.setAdapter(gankAdapter);
            }

            @Override
            public void onFailure(Call<GankBean> call, Throwable t) {
                log("failure");
            }
        });
    }

}
