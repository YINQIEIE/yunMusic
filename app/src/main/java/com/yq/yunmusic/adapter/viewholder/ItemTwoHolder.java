package com.yq.yunmusic.adapter.viewholder;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.BaseViewHolder;
import com.yq.yunmusic.http.response.GankBean;

import java.util.List;

import butterknife.BindView;

/**
 * 轮播图
 */
public class ItemTwoHolder extends BaseViewHolder {


    @BindView(R.id.iv_two_one_one)
    ImageView ivTwoOneOne;
    @BindView(R.id.tv_two_one_one_title)
    TextView tvTwoOneOneTitle;
    @BindView(R.id.ll_two_one_one)
    LinearLayout llTwoOneOne;
    @BindView(R.id.iv_two_one_two)
    ImageView ivTwoOneTwo;
    @BindView(R.id.tv_two_one_two_title)
    TextView tvTwoOneTwoTitle;
    @BindView(R.id.ll_two_one_two)
    LinearLayout llTwoOneTwo;
    @BindView(R.id.ll_two_one)
    LinearLayout llTwoOne;

    public ItemTwoHolder(Context mContext, @LayoutRes int resId) {
        super(LayoutInflater.from(mContext).inflate(R.layout.item_everyday_two, null));
    }

    @Override
    public void onBindViewHolder(List<GankBean.ResultBean> list, int position) {
        displayRandomImg(2, 0, ivTwoOneOne, list);
        displayRandomImg(2, 1, ivTwoOneTwo, list);
        setDes(list, 0, tvTwoOneOneTitle);
        setDes(list, 1, tvTwoOneTwoTitle);
    }


}
