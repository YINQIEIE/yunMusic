package com.yq.yunmusic.fragments;

import android.content.Context;
import android.os.AsyncTask;

import com.yq.yunmusic.entity.Song;
import com.yq.yunmusic.utils.MusicUtil;

import java.util.List;

/**
 * Created by yinqi on 2017/9/11.
 */

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
    }

}
