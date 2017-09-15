package com.yq.yunmusic.fragments;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseNavListFragment;
import com.yq.yunmusic.entity.Song;
import com.yq.yunmusic.utils.MusicUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by yinqi on 2017/9/12.
 * 本地音乐列表界面
 */

public class LocalSongsFragment extends BaseNavListFragment<Song> {

    @Override
    protected void initAdapter() {
        adapter = new CommonAdapter<Song>(getActivity(), R.layout.item_song, datas) {
            @Override
            protected void convert(ViewHolder holder, Song song, int position) {
                holder.setText(R.id.tv_title, song.getSongName());
                holder.setText(R.id.tv_subTitle, song.getArtist());
            }
        };

    }

    @Override
    protected List<Song> doInBackgroud() {
        return MusicUtil.getSongList(getActivity());
    }

    Pattern pattern = Pattern.compile("^[a-zA-Z]");

    @Override
    protected void onResult(List<Song> result) {
        for (int i = 0; i < result.size(); i++) {
            if (charMap.get(result.get(i).getFirstChar()) == null) {
                if (pattern.matcher(result.get(i).getFirstChar()).matches())
                    charMap.put(result.get(i).getFirstChar(), i);
                else
                    charMap.put("#", i);
            }
        }
        datas.addAll(result);
        adapter.notifyDataSetChanged();
    }


}
