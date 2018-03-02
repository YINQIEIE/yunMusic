package com.yq.yunmusic.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import com.yq.yunmusic.adapter.viewholder.WrapAdapter;

/**
 * Created by Administrator on 2018/1/9.
 */

public class XRecyclerView extends RecyclerView {

    private SparseArray<View> headerViews;
    private SparseArray<View> footerViews;
    private WrapAdapter wrapAdapter;

    public XRecyclerView(Context context) {
        super(context);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        headerViews = new SparseArray<>();
        footerViews = new SparseArray<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        return super.onTouchEvent(e);
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == RecyclerView.SCROLL_STATE_IDLE) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            int lastVisibleItemPosition;
            if (layoutManager instanceof GridLayoutManager) {
                lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                int comVisiblePos = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                Log.i("last visible", lastVisibleItemPosition + " >>> " + comVisiblePos);
                lastVisibleItemPosition = comVisiblePos;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] into = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(into);
                lastVisibleItemPosition = findMax(into);
            } else {
                lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                int comVisiblePos = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                Log.i("last visible", lastVisibleItemPosition + " >>> " + comVisiblePos);
            }
            if (layoutManager.getChildCount() > 0//判断有数据
                    && lastVisibleItemPosition >= layoutManager.getItemCount() - 1//最后一个完整可见的item的位置等于layoutmanager的最后一个item的位置
                    && layoutManager.getItemCount() > layoutManager.getChildCount())//item总数大于可见的数量
            {
                View footerView = footerViews.get(0);
                footerView.setVisibility(VISIBLE);
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadListener.load();
                    }
                }, 1000);
            }

        }

    }

    public void loadComplete() {
        footerViews.get(0).setVisibility(GONE);
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public void addHeaderView(View view) {
        headerViews.append(headerViews.size(), view);
    }

    public void addFooterView(View view) {
        footerViews.append(footerViews.size(), view);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        wrapAdapter = new WrapAdapter(adapter, headerViews, footerViews);
        super.setAdapter(wrapAdapter);
        adapter.registerAdapterDataObserver(mDataObserver);
    }

    private final AdapterDataObserver mDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            wrapAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            wrapAdapter.notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            wrapAdapter.notifyItemRangeChanged(positionStart, itemCount, payload);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            wrapAdapter.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            wrapAdapter.notifyItemRangeRemoved(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            wrapAdapter.notifyItemRangeRemoved(fromPosition, toPosition);
        }
    };

    public void setLoadListener(LoadListener loadListener) {
        this.loadListener = loadListener;
    }

    LoadListener loadListener;

    public interface LoadListener {
        void refresh();

        void load();
    }

}
