package com.yq.yunmusic.fragments;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;

import com.yq.yunmusic.R;
import com.yq.yunmusic.base.BaseListFragment;
import com.yq.yunmusic.entity.Album;
import com.yq.yunmusic.utils.BitmapHelper;
import com.yq.yunmusic.utils.MusicUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by yinqi on 2017/9/12.
 * 本地音乐列表界面
 */

public class FolderTabFragment extends BaseListFragment<Album> {

    @Override
    protected void initAdapter() {
        adapter = new CommonAdapter<Album>(getActivity(), R.layout.item_artist_album, datas) {
            @Override
            protected void convert(ViewHolder holder, Album album, int position) {
                ImageView ivAlbum = holder.getView(R.id.iv_icon);
                if (!TextUtils.isEmpty(album.getAlbum_art()))
                    ivAlbum.setImageBitmap(BitmapHelper.getRoundedCornerBitmap(BitmapFactory.decodeFile(album.getAlbum_art()), 120));
                else ivAlbum.setImageResource(R.mipmap.music);
                holder.setText(R.id.tv_name, album.getName());
                holder.setText(R.id.tv_artist, album.getArtist());
                holder.setText(R.id.tv_count, String.valueOf(album.getCount()) + "首");
            }
        };
        new GetAlbumsTask(getActivity()).execute();
    }

    public class GetAlbumsTask extends AsyncTask<Void, Void, List<Album>> {

        private Context context;

        public GetAlbumsTask(Context context) {
            this.context = context;
        }

        @Override
        protected List<Album> doInBackground(Void... voids) {
            MusicUtil.getFolders(getActivity());
            List<Album> albums = MusicUtil.getAlbums(getActivity());
            for (Album album : albums) {
                log(album.toString());
            }
            return MusicUtil.getAlbums(context);
        }

        @Override
        protected void onPostExecute(List<Album> alba) {
            datas.addAll(alba);
            adapter.notifyDataSetChanged();
        }
    }


}
