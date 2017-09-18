package com.yq.yunmusic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by yinqi on 2017/9/18.
 */

public class BottomBarFragment extends BaseFragment {
    @BindView(R.id.tv_song_name)
    TextView tvSongName;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_bar;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvSongName.requestFocus();
    }
}
