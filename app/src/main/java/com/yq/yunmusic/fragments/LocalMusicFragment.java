package com.yq.yunmusic.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseFragment;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * Created by yinqi on 2017/9/12.
 * 本地音乐列表界面
 */

public class LocalMusicFragment extends BaseFragment {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindArray(R.array.titles_local_music)
    String[] titles;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_local_music;
    }


}
