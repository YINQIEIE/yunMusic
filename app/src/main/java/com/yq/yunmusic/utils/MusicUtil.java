package com.yq.yunmusic.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;

import com.yq.yunmusic.entity.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinqi on 2017/9/11.
 */

public class MusicUtil {

    private static final Uri uri = Media.EXTERNAL_CONTENT_URI;
    private static final int MIN_DURATION = 60 * 1000;//最短时长一分钟
    private static final int MIN_SIZE = 1024 * 1024;//最小文件 1M

    /**
     * 歌曲查询列名称
     */
    public static final String[] PRO_SONG = new String[]{Media._ID, Media.TITLE, Media.ARTIST_ID, Media.ARTIST, Media.DURATION, Media.ALBUM_ID, Media.ALBUM, Media.SIZE, Media.DATA};

    /**
     * 歌曲查询条件
     */
    public static final String SEL_SONG = Media.SIZE + " > ? and " + Media.DURATION + " > ?";

    public static final String[] SEL_ARGS = new String[]{MIN_SIZE + "", MIN_DURATION + ""};

    public static ContentResolver getMusicResolver(Context context) {
        return context.getApplicationContext().getContentResolver();
    }

    public static List<Song> getSongList(Context context) {
        Cursor cursor = getMusicResolver(context).query(uri, PRO_SONG, SEL_SONG, SEL_ARGS, null);
        return getSongListByCursor(cursor);
    }

    public static List<Song> getSongListByCursor(Cursor cursor) {
        try {
            List<Song> songs = new ArrayList<>();
            if (null == cursor) return songs;
            while (cursor.moveToNext()) {
                Song song = new Song();
                song.setSongId(cursor.getInt(cursor.getColumnIndex(Media._ID)));
                song.setSongName(cursor.getString(cursor.getColumnIndex(Media.TITLE)));
                song.setArtistId(cursor.getInt(cursor.getColumnIndex(Media.ARTIST_ID)));
                song.setArtist(cursor.getString(cursor.getColumnIndex(Media.ARTIST)));
                song.setDuration(cursor.getInt(cursor.getColumnIndex(Media.DURATION)));
                song.setAlbumId(cursor.getInt(cursor.getColumnIndex(Media.ALBUM_ID)));
                song.setAlbum(cursor.getString(cursor.getColumnIndex(Media.ALBUM)));
                song.setSize(cursor.getInt(cursor.getColumnIndex(Media.SIZE)));
                song.setPath(cursor.getString(cursor.getColumnIndex(Media.DATA)));
                songs.add(song);
            }
            return songs;
        } finally {
            if (!cursor.isClosed())
                cursor.close();
        }
    }


}
