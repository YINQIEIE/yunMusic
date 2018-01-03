package com.yq.yunmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yq.yunmusic.http.response.GankBean;
import com.yq.yunmusic.utils.ImgLoadUtil;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/3.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void onBindViewHolder(List<GankBean.ResultBean> list, int position);

    protected void setDes(List<GankBean.ResultBean> object, int position, TextView textView) {
        textView.setText(object.get(position).getDesc());
    }

    protected void displayRandomImg(int imgNumber, int position, ImageView imageView, List<GankBean.ResultBean> object) {
        ImgLoadUtil.displayRandom(imgNumber, object.get(position).getUrl(), imageView);
    }
}
