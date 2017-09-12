package com.yq.yunmusic.fragments;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseListFragment;
import com.yq.yunmusic.entity.Song;
import com.yq.yunmusic.utils.MusicUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by yinqi on 2017/9/12.
 * 本地音乐列表界面
 */

public class SongsTabFragment extends BaseListFragment<Song> {

    @Override
    protected void initAdapter() {
        datas.addAll(MusicUtil.getSongList(getActivity()));
        adapter = new CommonAdapter<Song>(getActivity(), R.layout.item_song, datas) {
            @Override
            protected void convert(ViewHolder holder, Song song, int position) {
                holder.setText(R.id.tv_name, song.getSongName());
                holder.setText(R.id.tv_artist, song.getArtist());
            }
        };
    }


}
