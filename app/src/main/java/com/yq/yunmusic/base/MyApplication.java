package com.yq.yunmusic.base;

import android.app.Application;

/**
 * Created by Administrator on 2018/1/4.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
