package com.yq.yunmusic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yq.yunmusic.R;
import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yinqi on 2017/9/12.
 */

public abstract class BaseListFragment<T> extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    protected List<T> datas = new ArrayList<>();
    protected CommonAdapter<T> adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_local;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        initAdapter();
        recyclerView.setAdapter(adapter);
    }

    protected abstract void initAdapter();
}
