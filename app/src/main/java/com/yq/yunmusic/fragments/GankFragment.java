package com.yq.yunmusic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.MyFragmentAdapter;
import com.yq.yunmusic.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;

public class GankFragment extends BaseFragment {

    @BindView(R.id.tabLayout_gank)
    TabLayout tabLayoutGank;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindArray(R.array.titles_gank)
    String[] titles;

    private MyFragmentAdapter fragmentAdapter;
    private List<Fragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        fragments = new ArrayList<>();
        fragments.add(new EveryDayRecFragment());
        for (int i = 0; i < 3; i++) {
            fragments.add(new BlankFragment());
        }
        fragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), fragments, titles);
        vpContent.setAdapter(fragmentAdapter);
        tabLayoutGank.setupWithViewPager(vpContent);
    }


}
