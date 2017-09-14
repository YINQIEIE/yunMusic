package com.yq.yunmusic.fragments;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseListFragment;
import com.yq.yunmusic.entity.Artist;
import com.yq.yunmusic.entity.DetaisInfo;
import com.yq.yunmusic.utils.MusicUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by yinqi on 2017/9/12.
 * 我的音乐 -> 歌手界面
 */

public class LocalArtistFragment extends BaseListFragment<Artist> {

    @Override
    protected void initAdapter() {
        adapter = new CommonAdapter<Artist>(getActivity(), R.layout.item_artist_album, datas) {
            @Override
            protected void convert(ViewHolder holder, final Artist artist, int position) {
                holder.setText(R.id.tv_title, artist.getName());
                holder.setText(R.id.tv_subTitle, artist.getName());
                holder.setText(R.id.tv_subTitle1, String.valueOf(artist.getCount()) + "首");
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DetaisInfo detaisInfo = new DetaisInfo(1, artist.getName(), String.valueOf(artist.getId()));
                        LocalDetaisFragment fragment = LocalDetaisFragment.newInstance(detaisInfo);
                        FragmentTransaction transaction = LocalArtistFragment.this.mContext.getSupportFragmentManager().beginTransaction();
                        transaction.hide(LocalArtistFragment.this.mContext.getSupportFragmentManager().findFragmentByTag("local"));
                        transaction.addToBackStack(null);
                        transaction.add(R.id.fl_content, fragment).commit();

                    }
                });
            }
        };
    }

    @Override
    protected List<Artist> doInBackgroud() {
        return MusicUtil.getArtists(getActivity());
    }

    @Override
    protected void onResult(List<Artist> result) {
        datas.addAll(result);
        adapter.notifyDataSetChanged();
    }


}
