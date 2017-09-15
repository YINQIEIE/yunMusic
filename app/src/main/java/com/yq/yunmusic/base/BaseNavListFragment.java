package com.yq.yunmusic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.view.SideNavigationView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


public abstract class BaseNavListFragment<T> extends BaseListFragment<T> {

    @BindView(R.id.side_nav)
    SideNavigationView side_nav;
    @BindView(R.id.tv_nav)
    TextView tvNav;
    protected Map<String, Integer> charMap = new HashMap<>();

    @Override
    protected int getLayoutId() {
        return R.layout.layout_list_with_side_nav;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        side_nav.setTv(tvNav);
        side_nav.setMovingListener(new SideNavigationView.GestureListener() {
            @Override
            public void onMoving(int pos, String s) {
                if (null != charMap.get(s)) {
                    recyclerView.scrollToPosition(charMap.get(s));
                }
            }

            @Override
            public void onTouch(int pos, String s) {
                if (null != charMap.get(s))
                    recyclerView.scrollToPosition(charMap.get(s));
            }
        });
    }

}
