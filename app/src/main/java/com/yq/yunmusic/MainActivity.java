package com.yq.yunmusic;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.yq.yunmusic.adapter.MyFragmentAdapter;
import com.yq.yunmusic.base.BaseActivity;
import com.yq.yunmusic.base.BaseFragment;
import com.yq.yunmusic.fragments.SongsFragment;
import com.yq.yunmusic.statusbar.StatusBarUtil;
import com.yq.yunmusic.utils.BitmapHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindArray(R.array.titles_main)
    String[] titles;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private MyFragmentAdapter adapter;
    private View headerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this, drawer,
                getResources().getColor(R.color.themeColor));
        init();
    }

    private void init() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        headerView = navigationView.getHeaderView(0);
        ImageView imageView = (ImageView) headerView.findViewById(R.id.iv_avater);
        imageView.setImageBitmap(BitmapHelper.getRoundCornerBitmapWithBorder(getResources(), R.mipmap.icon_avater, 14));
        initViewPager();
    }

    private void initViewPager() {
        List<BaseFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fragments.add(new SongsFragment());
        }
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_homepage) {
            // Handle the camera action
        } else if (id == R.id.nav_scan_download) {

        } else if (id == R.id.nav_about_yueyun) {

        } else if (id == R.id.nav_github_login) {

        } else if (id == R.id.exit) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
