package com.yq.yunmusic.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yq.yunmusic.R;
import com.yq.yunmusic.adapter.BaseViewHolder;
import com.yq.yunmusic.http.response.GankBean;

import java.util.List;

import butterknife.BindView;

/**
 * 轮播图
 */
public class ItemOneHolder extends BaseViewHolder {

    @BindView(R.id.ll_one_photo_line)
    View llOnePhotoLine;
    @BindView(R.id.iv_one_photo)
    ImageView ivOnePhoto;
    @BindView(R.id.tv_one_photo_title)
    TextView tvOnePhotoTitle;
    @BindView(R.id.ll_one_photo)
    LinearLayout llOnePhoto;

    public ItemOneHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_everyday_one, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(List<GankBean.ResultBean> list, int position) {
        if ("福利".equals(list.get(0).getType())) {
            tvOnePhotoTitle.setVisibility(View.GONE);
            ivOnePhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            ImgLoadUtil.displayEspImage(list.get(0).getUrl(), ivOnePhoto, 1);
            Glide.with(ivOnePhoto.getContext())
                    .load(list.get(0).getUrl())
                    .crossFade(1500)
                    .placeholder(R.drawable.img_two_bi_one)
                    .error(R.drawable.img_two_bi_one)
                    .into(ivOnePhoto);

        } else {
            tvOnePhotoTitle.setVisibility(View.VISIBLE);
            setDes(list, 0, tvOnePhotoTitle);
            displayRandomImg(1, 0, ivOnePhoto, list);
        }
    }

}
