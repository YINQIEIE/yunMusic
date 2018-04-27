package com.yq.yunmusic.view;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yinqi on 2018/4/27.
 */

public interface RefreshInterface {
    int STATE_NORMAL = 0;
    int STATE_RELEASE_TO_REFRESH = 1;
    int STATE_REFRESH_START = 2;
    int STATE_REFRESHING = 3;

    @IntDef(value = {STATE_NORMAL, STATE_RELEASE_TO_REFRESH, STATE_REFRESH_START, STATE_REFRESHING})
    @Retention(RetentionPolicy.SOURCE)
    @interface StateRange {
    }

    void reset();

    void onReleaseToRefresh();

    void onRefreshStart();

    void onRefreshing();

    void refreshComplete();
}
