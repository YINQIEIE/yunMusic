package com.yq.yunmusic.fragments;

import android.content.Context;
import android.os.AsyncTask;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseListFragment;
import com.yq.yunmusic.entity.Artist;
import com.yq.yunmusic.utils.MusicUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by yinqi on 2017/9/12.
 * 本地音乐列表界面
 */

public class ArtistTabFragment extends BaseListFragment<Artist> {

    @Override
    protected void initAdapter() {
        adapter = new CommonAdapter<Artist>(getActivity(), R.layout.item_artist_album, datas) {
            @Override
            protected void convert(ViewHolder holder, Artist artist, int position) {
//                holder.setImageResource(R.id.)
                holder.setText(R.id.tv_name, artist.getName());
                holder.setText(R.id.tv_artist, artist.getName());
                holder.setText(R.id.tv_count, String.valueOf(artist.getCount()));
            }
        };
        new GetAlbumsTask(getActivity()).execute();
    }

    public class GetAlbumsTask extends AsyncTask<Void, Void, List<Artist>> {

        private Context context;

        public GetAlbumsTask(Context context) {
            this.context = context;
        }

        @Override
        protected List<Artist> doInBackground(Void... voids) {
            List<Artist> artists = MusicUtil.getArtists(getActivity());
            for (Artist artist : artists) {
                log(artist.toString());
            }
            return MusicUtil.getArtists(context);
        }

        @Override
        protected void onPostExecute(List<Artist> alba) {
            datas.addAll(alba);
            adapter.notifyDataSetChanged();
        }
    }


}
