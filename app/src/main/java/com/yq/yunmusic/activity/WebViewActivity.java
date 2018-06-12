package com.yq.yunmusic.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseActivity;
import com.yq.yunmusic.http.response.AppDatabase;
import com.yq.yunmusic.http.response.BlogBean;
import com.yq.yunmusic.http.response.GankBean;

import java.lang.reflect.Method;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.parent)
    FrameLayout parent;
    private WebView webView;
    private String webUrl;
    boolean hasLoaded = false;
    private GankBean.ResultBean info;
    private Disposable dbSubscribe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从底部进入
        overridePendingTransition(R.anim.activity_bottom_in, R.anim.activity_bottom_no);
        initToolbar();
        initWebView();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("加载中...");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.actionbar_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web_view;
    }

    private void initWebView() {
        webView = new WebView(this.getApplication());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            webView.setWebContentsDebuggingEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if (newProgress == 100)
                    progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                toolbar.setTitle(title);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            /**
             * {@link #shouldOverrideUrlLoading 不一定走}
             * @param view
             * @param url
             * @param favicon
             */
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (!hasLoaded) {
                    hasLoaded = true;
//                    webUrl = url;
                    view.loadUrl(url);
                }
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!hasLoaded) {
                    hasLoaded = true;
//                    webUrl = url;
                    view.loadUrl(url);
                }
                return true;
            }
        });
        WebSettings webSettings = webView.getSettings();
        // 网页内容的宽度是否可大于WebView控件的宽度
        webSettings.setLoadWithOverviewMode(false);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        //是否支持 viewport 标签
        webSettings.setUseWideViewPort(true);
//        // 网页内容的宽度是否可大于WebView控件的宽度
//        webSettings.setLoadWithOverviewMode(false);
        //使用 localstorage 和 sessionstorage
//        webSettings.setDomStorageEnabled(true);
//        // webview从5.0开始默认不允许混合模式,https中不能加载http资源,需要设置开启。
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
//        // WebView是否支持多个窗口。
//        webSettings.setSupportMultipleWindows(true);
        // 缩放比例 1
        webView.setInitialScale(1);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //排版适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        info = (GankBean.ResultBean) getIntent().getExtras().get("info");
        log(info.toString());
        webView.loadUrl(webUrl = info.getUrl());
        log("from intent" + webUrl);
        parent.addView(webView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setOptionalIconsVisibility(menu);
        getMenuInflater().inflate(R.menu.web_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 利用方式设置 menu item 图标可见
     *
     * @param menu
     */
    private void setOptionalIconsVisibility(Menu menu) {
        try {
            if (null != menu) {
                Method method = MenuBuilder.class.getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(menu, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:

                break;
            case R.id.collection://收藏
                collectBlog();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 收藏博客
     */
    private void collectBlog() {
//        DbManager dbManager = new DbManager(this);
//        List<String> list = dbManager.queryAllBlogs();
//        for (int i = 0; i < list.size(); i++) {
//            log(list.get(i));
//        }
//        if (dbManager.addBlog(webUrl))
//            toast("收藏成功");
        final BlogBean blogBean = new BlogBean(info);
        AppDatabase.getInstance(WebViewActivity.this).getBlogDao().insertSingleBlog(blogBean);
        dbSubscribe = Observable.create((ObservableOnSubscribe<Long>) e -> AppDatabase.getInstance(WebViewActivity.this).getBlogDao().insertSingleBlog(blogBean)).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    if (id > 0) {
                        toast("收藏成功");
                        if (!dbSubscribe.isDisposed())
                            dbSubscribe.dispose();
                    }
                }, throwable -> {
                    toast("收藏失败");
                    if (!dbSubscribe.isDisposed())
                        dbSubscribe.dispose();
                });
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                BlogBean blogBean = new BlogBean(info);
//                log(AppDatabase.getInstance(WebViewActivity.this).getBlogDao().insertSingleBlog(blogBean));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                List<BlogBean> blogs = AppDatabase.getInstance(WebViewActivity.this).getBlogDao().findAll();
//                for (int i = 0; i < blogs.size(); i++) {
//                    log(blogs.get(i).toString());
//                }
//            }
//        }.start();
    }

    @Override
    protected void onDestroy() {
//        clearCookies();
        super.onDestroy();
        webView.destroy();
    }

    /**
     * 清除 cookies
     * 21 之前用 cookieSyncManager.sync()
     * 21 之后用 cookieManager.flush()
     */
    private void clearCookies() {
//        webView.clearCache(true);
        CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance(getApplicationContext());
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieSyncManager.sync();
        } else {
            cookieManager.removeAllCookies(null);
            cookieManager.removeSessionCookies(null);
            cookieManager.flush();
        }
//        String cookie = cookieManager.getCookie(webUrl);
//        log("webview cookie destroy" + cookie);
    }

    /**
     * 打开网页:
     *
     * @param mContext 上下文
     * @param mUrl     要加载的网页url
     * @param mTitle   title
     */
    public static void loadUrl(Context mContext, String mUrl, String mTitle) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("url", mUrl);
        intent.putExtra("mTitle", mTitle);
        mContext.startActivity(intent);
    }

    /**
     * 打开对应网址
     *
     * @param mContext
     * @param info
     */
    public static void loadUrl(Context mContext, GankBean.ResultBean info) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", info);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    protected void setFinishTransaction() {
        //从底部退出
        overridePendingTransition(0, R.anim.activity_bottom_out);
    }
}
