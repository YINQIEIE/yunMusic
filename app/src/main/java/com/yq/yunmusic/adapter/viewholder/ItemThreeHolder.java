package com.yq.yunmusic.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
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
public class ItemThreeHolder extends BaseViewHolder {

    @BindView(R.id.iv_three_one_one)
    ImageView ivThreeOneOne;
    @BindView(R.id.tv_three_one_one_title)
    TextView tvThreeOneOneTitle;
    @BindView(R.id.ll_three_one_one)
    LinearLayout llThreeOneOne;
    @BindView(R.id.iv_three_one_two)
    ImageView ivThreeOneTwo;
    @BindView(R.id.tv_three_one_two_title)
    TextView tvThreeOneTwoTitle;
    @BindView(R.id.ll_three_one_two)
    LinearLayout llThreeOneTwo;
    @BindView(R.id.iv_three_one_three)
    ImageView ivThreeOneThree;
    @BindView(R.id.tv_three_one_three_title)
    TextView tvThreeOneThreeTitle;
    @BindView(R.id.ll_three_one_three)
    LinearLayout llThreeOneThree;
    @BindView(R.id.ll_three_one)
    LinearLayout llThreeOne;

    public ItemThreeHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_everyday_three, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(List<GankBean.ResultBean> list, int position) {
        displayRandomImg(3, 0, ivThreeOneOne, list);
        displayRandomImg(3, 1, ivThreeOneTwo, list);
        displayRandomImg(3, 2, ivThreeOneThree, list);
        setDes(list, 0, tvThreeOneOneTitle);
        setDes(list, 1, tvThreeOneTwoTitle);
        setDes(list, 2, tvThreeOneThreeTitle);
    }


}
