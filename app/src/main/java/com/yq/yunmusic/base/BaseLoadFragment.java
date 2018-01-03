package com.yq.yunmusic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by yinqi on 2017/9/9.
 * 需要从网络获取数据
 */

public abstract class BaseLoadFragment extends BaseFragment {

    protected boolean isViewCreated, isDataLoaded;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        isViewCreated = true;
        loadData();
        return rootView;
    }

    /**
     * {@link #isVisible()} 只会调用一次，之后就一直为 true
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        loadData();
    }

    protected void loadData() {
        if (getUserVisibleHint() && isViewCreated && !isDataLoaded) {
            getData();
            isDataLoaded = true;
        }
    }

    protected abstract void getData();


}
