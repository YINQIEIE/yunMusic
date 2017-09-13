package com.yq.yunmusic.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.MyFragmentAdapter;
import com.yq.yunmusic.base.BaseActivity;
import com.yq.yunmusic.base.BaseListFragment;
import com.yq.yunmusic.fragments.AlbumTabFragment;
import com.yq.yunmusic.fragments.ArtistTabFragment;
import com.yq.yunmusic.fragments.SongsTabFragment;
import com.yq.yunmusic.statusbar.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;

public class LocalMusicActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_local)
    ViewPager vpLocal;

    @BindArray(R.array.titles_local_music)
    String[] titles;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private List<BaseListFragment> fragments = new ArrayList<>();
    private MyFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.themeColor));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.actionbar_back);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);

        tvTitle.setText("我的音乐");

        fragments.add(new SongsTabFragment());
        fragments.add(new ArtistTabFragment());
        fragments.add(new AlbumTabFragment());
        fragments.add(new AlbumTabFragment());

        adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        vpLocal.setOffscreenPageLimit(fragments.size() - 1);
        vpLocal.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpLocal);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_local_music;
    }
}
