package com.yq.yunmusic.activity;

import android.graphics.Color;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseActivity;
import com.yq.yunmusic.statusbar.StatusBarUtil;

public class MovieDetailActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void setTheme() {
        StatusBarUtil.setColor(this, Color.WHITE, 0);
    }


}
