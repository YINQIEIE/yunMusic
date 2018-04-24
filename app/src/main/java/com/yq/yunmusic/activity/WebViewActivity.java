package com.yq.yunmusic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
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

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.parent)
    FrameLayout parent;
    private WebView webView;
    private String webUrl;

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
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                log("override" + url);
                webUrl = url;
                view.loadUrl(url);
                return false;
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
        webView.loadUrl(getIntent().getStringExtra("url"));
        parent.addView(webView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
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

    @Override
    protected void setFinishTransaction() {
        //从底部退出
        overridePendingTransition(0, R.anim.activity_bottom_out);
    }
}
