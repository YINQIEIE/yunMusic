package com.yq.yunmusic.fragments;

import android.widget.TextView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseListFragment;
import com.yq.yunmusic.entity.Song;
import com.yq.yunmusic.utils.MusicUtil;
import com.yq.yunmusic.view.SideNavigationView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yinqi on 2017/9/12.
 * 本地音乐列表界面
 */

public class LocalSongsFragment extends BaseListFragment<Song> {

    @BindView(R.id.side_nav)
    SideNavigationView side_nav;
    @BindView(R.id.tv_nav)
    TextView tvNav;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_list_with_side_nav;
    }

    @Override
    protected void initAdapter() {
        adapter = new CommonAdapter<Song>(getActivity(), R.layout.item_song, datas) {
            @Override
            protected void convert(ViewHolder holder, Song song, int position) {
                holder.setText(R.id.tv_title, song.getSongName());
                holder.setText(R.id.tv_subTitle, song.getArtist());
            }
        };

        side_nav.setTv(tvNav);
    }

    @Override
    protected List<Song> doInBackgroud() {
        return MusicUtil.getSongList(getActivity());
    }

    @Override
    protected void onResult(List<Song> result) {
        datas.addAll(result);
        adapter.notifyDataSetChanged();
    }


}
