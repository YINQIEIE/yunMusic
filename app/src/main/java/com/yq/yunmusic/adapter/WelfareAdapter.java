package com.yq.yunmusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yq.yunmusic.R;
import com.yq.yunmusic.http.response.GankBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/10.
 * 干活定制
 */

public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.ItemHolder> {

    private Context mContext;
    private List<GankBean.ResultBean> data;

    public WelfareAdapter(Context mContext, List<GankBean.ResultBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public WelfareAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photo, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(WelfareAdapter.ItemHolder holder, int position) {
        //占位图会导致图片失真
        Glide.with(mContext).load(data.get(position).getUrl()).crossFade(1000).into(holder.imageView);
//        ImgLoadUtil.displayImage(mContext, data.get(position).getUrl(), holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_photo)
        ImageView imageView;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
