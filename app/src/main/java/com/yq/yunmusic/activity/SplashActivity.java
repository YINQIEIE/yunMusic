package com.yq.yunmusic.activity;

import android.os.Bundle;
import android.os.Handler;

import com.yq.yunmusic.MainActivity;
import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startNewActivity(MainActivity.class);
                finish();
                setStartTransaction();
            }
        }, 3000);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setStartTransaction() {
        overridePendingTransition(R.anim.activity_zoom_in, R.anim.activity_zoom_out);
    }

    @Override
    protected void setFinishTransaction() {

    }
}
