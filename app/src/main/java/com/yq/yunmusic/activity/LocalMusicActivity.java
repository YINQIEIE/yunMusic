package com.yq.yunmusic.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseActivity;
import com.yq.yunmusic.fragments.LocalMusicFragment;

import butterknife.BindView;

public class LocalMusicActivity extends BaseActivity {


    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.fl_bottom_bar)
    FrameLayout flBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new LocalMusicFragment();
        transaction.add(R.id.fl_content, fragment, "local").commitAllowingStateLoss();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_local_music;
    }
}
