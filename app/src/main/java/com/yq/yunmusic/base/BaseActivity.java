package com.yq.yunmusic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yq.yunmusic.R;
import com.yq.yunmusic.statusbar.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * Created by yinqi on 2017/9/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        setTheme();
    }

    protected void setTheme() {
        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(R.color.themeColor));
    }

    protected abstract int getLayoutResId();

    /**
     * 日志打印
     *
     * @param content 日志内容
     */
    protected void log(Object content) {
        Log.i(TAG, String.valueOf(content));
    }

}
