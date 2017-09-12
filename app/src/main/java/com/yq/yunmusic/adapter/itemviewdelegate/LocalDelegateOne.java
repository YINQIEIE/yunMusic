package com.yq.yunmusic.adapter.itemviewdelegate;

import com.yq.yunmusic.R;
import com.yq.yunmusic.entity.LocalInfo;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by yinqi on 2017/9/12.
 */

public class LocalDelegateOne implements ItemViewDelegate<LocalInfo> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.fragment_local_item_one;
    }

    @Override
    public boolean isForViewType(LocalInfo item, int position) {
        return position < 4;
    }

    @Override
    public void convert(ViewHolder holder, LocalInfo localInfo, int position) {
        holder.setImageResource(R.id.iv_icon, localInfo.getIconId());
        holder.setText(R.id.tv_title, localInfo.getTitle());
        holder.setText(R.id.tv_count, String.valueOf(localInfo.getCount()));
    }
}
