package com.yq.yunmusic.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseActivity;
import com.yq.yunmusic.entity.BookBean;
import com.yq.yunmusic.utils.ImgLoadUtil;

import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class BookDetailActivity extends BaseActivity {

    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_rating)
    TextView tvRating;
    @BindView(R.id.tv_rating_number)
    TextView tvRatingNumber;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.tv_summary)
    TextView tvSummary;
    @BindView(R.id.tv_author_intr)
    TextView tvAuthorIntr;
    @BindView(R.id.tv_catalog)
    TextView tvCatalog;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_pubDate)
    TextView tvPubDate;
    @BindView(R.id.tv_publisher)
    TextView tvPublisher;

    private BookBean bookBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookBean = (BookBean) getIntent().getSerializableExtra("bookInfo");
        initToolBar();
        //在 transition 动画结束后再请求信息，否则在上个页面会看到加载 dialog
        setEnterSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                initBookInfo();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_book_detail;
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(bookBean.getTitle());
        //设置toolbar_layout 是否显示标题
        //true 显示，toolbar 标题会随着页面滑动切换位置
        //false 不显示，标题固定在 toolbar 标题位置不动
        toolbarLayout.setTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        appBar.getTotalScrollRange()此处获取值为 0
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                log("alpha-maxOff = " + appBarLayout.getTotalScrollRange());
                float ratio = (float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange();
                //不要标题栏渐变
                toolbar.setBackgroundColor(changeAlpha(Color.WHITE, ratio * 0.4f));
//                if (ratio == 0)
//                    toolbar.setTitleTextColor(Color.WHITE);
//                else
//                    toolbar.setTitleTextColor(changeAlpha(Color.BLACK, ratio));
            }
        });
    }

    private void initBookInfo() {
        Glide.with(this).load(bookBean.getImages().getMedium())
                .error(R.drawable.stackblur_default)
                .bitmapTransform(new BlurTransformation(this, 23, 4)).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(ivBg);
        //删除 transition 动画监听，否则会有异常
        setEnterSharedElementCallback(new SharedElementCallback() {
        });
//        showLoadingDialog();
        ImgLoadUtil.displayImage(this, bookBean.getImages().getMedium(), ivPhoto);
        tvAuthor.setText("作者：" + bookBean.getAuthor());
        tvRating.setText("评分：" + bookBean.getRating().getAverage());
        tvRatingNumber.setText(String.format("%d人评分", bookBean.getRating().getNumRaters()));
        tvPubDate.setText("出版时间：" + bookBean.getPubdate());
        tvPublisher.setText(bookBean.getPublisher());
        tvSummary.setText(bookBean.getSummary());
        tvAuthorIntr.setText(bookBean.getAuthor_intro());
        tvCatalog.setText(bookBean.getCatalog());
        getBookDetails();
    }

    private void getBookDetails() {
//        Call movieDetailCall = RetrofitManager.getDouBanHttpService(this).getBookDetail(bookBean.getId());
//        movieDetailCall.enqueue(new Callback<MovieDetailBean>() {
//            @Override
//            public void onResponse(Call<MovieDetailBean> call, Response<MovieDetailBean> response) {
//                dismissLoadingDialog();
//                MovieDetailBean body = response.body();
//                if (null != body) {
//                    log(body.toString());
//                    tvSummary.setText(body.getSummary());
//                    setActors();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieDetailBean> call, Throwable t) {
//                dismissLoadingDialog();
//            }
//        });
    }

    /**
     * 根据百分比改变颜色透明度
     */
    public int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }

    @Override
    protected void setTheme() {

    }

    public static void start(Context context, BookBean bean, ImageView ivPhoto) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra("bookInfo", bean);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, ivPhoto, context.getString(R.string.book_transition));
        ActivityCompat.startActivity(context, intent, optionsCompat.toBundle());
    }

}
