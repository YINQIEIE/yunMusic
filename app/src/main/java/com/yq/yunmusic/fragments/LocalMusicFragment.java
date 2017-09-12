package com.yq.yunmusic.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseFragment;
import com.yq.yunmusic.entity.Song;
import com.yq.yunmusic.utils.MusicUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yinqi on 2017/9/11.
 */

public class LocalMusicFragment extends BaseFragment {

    /**
     * 列表 item 种类
     */
    public static final class ITEM_TYPE {
        public static final int ITEM_NORMAL = 0;
        public static final int ITEM_SECTION = 1;
        public static final int SECTION_CHILD = 2;
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<LocalInfo> infos = new ArrayList<>();
    private CommonAdapter adapter;
    private MultiItemTypeAdapter multiAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_local_music;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        infos.add(new LocalInfo(getString(R.string.local_music), 0, R.mipmap.music_icn_local));
        infos.add(new LocalInfo(getString(R.string.recent_play), 0, R.mipmap.music_icn_recent));
        infos.add(new LocalInfo(getString(R.string.download_manage), 0, R.mipmap.music_icn_dld));
        infos.add(new LocalInfo(getString(R.string.artist), 0, R.mipmap.music_icn_artist));
        infos.add(new LocalInfo("我的歌单", 0, R.mipmap.music_icn_artist));

        multiAdapter = new MultiItemTypeAdapter(getActivity(), infos);
        multiAdapter.addItemViewDelegate(new ItemViewDelegate<LocalInfo>() {

            @Override
            public int getItemViewLayoutId() {
                return R.layout.fragment_local_item_normal;
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
        });

        multiAdapter.addItemViewDelegate(new ItemViewDelegate<LocalInfo>() {

            @Override
            public int getItemViewLayoutId() {
                return R.layout.item_songs_menu;
            }

            @Override
            public boolean isForViewType(LocalInfo item, int position) {
                return position == 4;
            }

            @Override
            public void convert(ViewHolder holder, LocalInfo localInfo, int position) {
//                holder.setImageResource(R.id.iv_icon, localInfo.getIconId());
                holder.setText(R.id.tv_title, localInfo.getTitle());
//                holder.setText(R.id.tv_count, String.valueOf(localInfo.getCount()));
                setMenuRecyclerView((RecyclerView) holder.getView(R.id.rv_menu));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(multiAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        new GetSongsTask(getActivity()).execute();
    }

    private void setMenuRecyclerView(RecyclerView recyclerView) {
        List<LocalInfo> menus = new ArrayList<>();
        menus.add(new LocalInfo("流行", 100, R.mipmap.icon_menu_created));
        menus.add(new LocalInfo("摇滚", 100, R.mipmap.icon_menu_created));
        menus.add(new LocalInfo("古典", 100, R.mipmap.icon_menu_created));
        adapter = new CommonAdapter<LocalInfo>(getActivity(), R.layout.item_songs_menu_rv, menus) {

            @Override
            protected void convert(ViewHolder holder, LocalInfo localInfo, int position) {
                holder.setText(R.id.tv_menu_name, localInfo.getTitle());
                holder.setText(R.id.tv_count, localInfo.getCount() + "首");
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private class LocalInfo {

        private String title;//标题
        private int count;//数量
        private int iconId;//图标

        public LocalInfo(String title, int count, int iconId) {
            this.title = title;
            this.count = count;
            this.iconId = iconId;
        }

        public String getTitle() {
            return title;
        }

        public int getCount() {
            return count;
        }

        public int getIconId() {
            return iconId;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }

    public class GetSongsTask extends AsyncTask<Void, Void, List<Song>> {

        private Context context;
        private List<Song> songs;

        public GetSongsTask(Context context) {
            this.context = context;
        }

        @Override
        protected List<Song> doInBackground(Void... voids) {
            return MusicUtil.getSongList(context);
        }

        @Override
        protected void onPostExecute(List<Song> songs) {
            this.songs = songs;
            infos.get(0).setCount(songs.size());
            multiAdapter.notifyItemChanged(0);

        }

    }
}
