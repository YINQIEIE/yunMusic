package com.yq.yunmusic.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.viewholder.AndroidAdapter;
import com.yq.yunmusic.base.BaseLoadFragment;
import com.yq.yunmusic.http.RetrofitManager;
import com.yq.yunmusic.http.response.GankBean;
import com.yq.yunmusic.view.FooterView;
import com.yq.yunmusic.view.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GankChildFragment extends BaseLoadFragment {

    @BindView(R.id.rv_ganks)
    XRecyclerView rvGanks;
    private List<GankBean.ResultBean> list;
    private AndroidAdapter adapter;
    private int page = 1;
    private View mHeaderView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_child;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        list = new ArrayList<>();
        adapter = new AndroidAdapter(getActivity(), list);
        rvGanks.setLayoutManager(new LinearLayoutManager(getActivity()));
        addHeaderView();
        rvGanks.addFooterView(new FooterView(getActivity()));
        rvGanks.setAdapter(adapter);
        rvGanks.setLoadListener(new XRecyclerView.LoadListener() {
            @Override
            public void refresh() {

            }

            @Override
            public void load() {
                page += 1;
                getData();
            }
        });

    }

    private void addHeaderView() {
        if (mHeaderView == null) {
            mHeaderView = View.inflate(getContext(), R.layout.header_item_gank_child, null);
            rvGanks.addHeaderView(mHeaderView);
        }
        initHeader(mHeaderView);
    }

    private void initHeader(View mHeaderView) {
        final TextView txName = (TextView) mHeaderView.findViewById(R.id.tx_name);
        String gankCala = .getString("gank_cala", "全部");
        txName.setText(gankCala);
        View view = mHeaderView.findViewById(R.id.ll_choose_catalogue);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new BottomSheet.Builder(getActivity(), R.style.BottomSheet_StyleDialog).title("选择分类").sheet(R.menu.gank_bottomsheet).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case R.id.gank_all:
                                if (isOtherType("全部")) {
                                    txName.setText("全部");
                                    mType = "all";// 全部传 all
                                    mPage = 1;
                                    mAndroidAdapter.clear();
                                    SPUtils.putString("gank_cala", "全部");
                                    showLoading();
                                    loadCustomData();
                                }
                                break;
                            case R.id.gank_ios:
                                if (isOtherType("IOS")) {
                                    txName.setText("IOS");
                                    mType = "iOS";// 这里有严格大小写
                                    mPage = 1;
                                    mAndroidAdapter.clear();
                                    SPUtils.putString("gank_cala", "IOS");
                                    showLoading();
                                    loadCustomData();
                                }
                                break;
                            case R.id.gank_qian:
                                if (isOtherType("前端")) {
                                    changeContent(txName, "前端");
                                }
                                break;
                            case R.id.gank_app:
                                if (isOtherType("App")) {
                                    changeContent(txName, "App");
                                }
                                break;
                            case R.id.gank_movie:
                                if (isOtherType("休息视频")) {
                                    changeContent(txName, "休息视频");
                                }
                                break;
                            case R.id.gank_resouce:
                                if (isOtherType("拓展资源")) {
                                    changeContent(txName, "拓展资源");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }).show();

            }
        });
    }

    @Override
    protected void getData() {
        final Call<GankBean<List<GankBean.ResultBean>>> photoCall = RetrofitManager.getGankHttpService().getGankInfo("Android", page, 10);
        photoCall.enqueue(new Callback<GankBean<List<GankBean.ResultBean>>>() {
            @Override
            public void onResponse(Call<GankBean<List<GankBean.ResultBean>>> call, Response<GankBean<List<GankBean.ResultBean>>> response) {
                log(response.body().toString());
                List<GankBean.ResultBean> data = response.body().getResults();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GankBean<List<GankBean.ResultBean>>> call, Throwable t) {
                if (page > 1) page--;
            }
        });

    }


}
