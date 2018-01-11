package com.yq.yunmusic.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yq.yunmusic.R;

/**
 * Created by Administrator on 2018/1/11.
 */

public class FooterView extends LinearLayout {

    private ImageView ivLoading;

    public FooterView(Context context) {
        this(context, null);
    }

    public FooterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        View view = LayoutInflater.from(context).inflate(R.layout.layout_loading, this, false);
//        this.addView(view);
        View.inflate(context, R.layout.layout_loading, this);
        ivLoading = findViewById(R.id.iv_loading);
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        AnimationDrawable animationDrawable = (AnimationDrawable) ivLoading.getDrawable();
        if (visibility == View.VISIBLE) {
            if (!animationDrawable.isRunning())
                animationDrawable.start();
        } else if (visibility == View.GONE) {
            if (animationDrawable.isRunning())
                animationDrawable.stop();
        }
    }

}
