package com.yq.yunmusic.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseFragment;

import butterknife.BindView;

public class SongsFragment extends BaseFragment {

    @BindView(R.id.tv_content)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_songs;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_LONG).show();
            }
        });

    }
}

