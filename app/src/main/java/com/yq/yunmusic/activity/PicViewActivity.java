package com.yq.yunmusic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.ViewPagerAdapter;
import com.yq.yunmusic.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PicViewActivity extends BaseActivity {

    private ArrayList<View> views;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private ViewPagerAdapter adapter;
    private List<String> pics;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pic_view;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        initViews();
        initData();
    }

    public void initViews() {
        views = new ArrayList<>();
        adapter = new ViewPagerAdapter(views);
        viewPager.setOffscreenPageLimit(0);
    }


    private void initData() {
        pics = getIntent().getStringArrayListExtra("pics");
        int pos = getIntent().getIntExtra("picPosition", 0);
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < pics.size(); i++) {
//            SimpleDraweeView iv = new SimpleDraweeView(this);
////            PhotoViewAttacher attacher = new PhotoViewAttacher(iv);
////            PhotoView photoView = new PhotoView(this);
//            PhotoDraweeView photoDraweeView = new PhotoDraweeView(this);
//            photoDraweeView.setPhotoUri(Uri.parse(pics.get(i)));
//            photoDraweeView.setLayoutParams(mParams);
//            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
////            iv.setImageBitmap(setBitmapFromResource(pics[i]));
//            views.add(photoDraweeView);
        }

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);

    }
}
