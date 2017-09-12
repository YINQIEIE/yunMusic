package com.yq.yunmusic.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;

import com.yq.yunmusic.entity.Artist;
import com.yq.yunmusic.entity.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinqi on 2017/9/11.
 */

public class MusicUtil {

    private static final int MIN_DURATION = 60 * 1000;//最短时长一分钟
    private static final int MIN_SIZE = 1024 * 1024;//最小文件 1M

    /**
     * 歌曲查询列名称
     */
    public static final String[] PRO_SONG = new String[]{Media._ID, Media.TITLE, Media.ARTIST_ID, Media.ARTIST, Media.DURATION, Media.ALBUM_ID, Media.ALBUM, Media.SIZE, Media.DATA};
    /**
     * 歌手查询列名称
     */
    public static final String[] PRO_ATRIST = new String[]{MediaStore.Audio.Artists._ID, MediaStore.Audio.Artists.ARTIST, MediaStore.Audio.Artists.NUMBER_OF_TRACKS};
    /**
     * 歌曲查询条件
     */
    public static final String SEL_SONG = Media.SIZE + " > ? and " + Media.DURATION + " > ?";
    /**
     * 歌曲查询条件
     */
    public static final String SEL_ARTIST = MediaStore.Audio.Artists._ID
            + "in (" +
            "select distinct " + Media.ARTIST_ID + " FROM audio_meta WHERE" + Media.SIZE + " > " + MIN_SIZE + "and " + Media.DURATION + " > " + MIN_DURATION
            + ")";

    public static final String[] SEL_ARGS = new String[]{MIN_SIZE + "", MIN_DURATION + ""};

    public static ContentResolver getMusicResolver(Context context) {
        return context.getApplicationContext().getContentResolver();
    }

    public static List<Song> getSongList(Context context) {
        Cursor cursor = getMusicResolver(context).query(Media.EXTERNAL_CONTENT_URI, PRO_SONG, SEL_SONG, SEL_ARGS, null);
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
            if (null != cursor && !cursor.isClosed())
                cursor.close();
        }
    }

    /**
     * 获取歌手信息
     *
     * @param context
     * @return
     */
    public static List<Artist> getArtists(Context context) {
        Cursor cursor = getMusicResolver(context).query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, PRO_ATRIST, null, null, MediaStore.Audio.Artists.DEFAULT_SORT_ORDER/*A - Z*/);
        return getArtistListByCursor(cursor);
    }

    public static List<Artist> getArtistListByCursor(Cursor cursor) {
        try {
            List<Artist> artists = new ArrayList<>();
            if (null == cursor) return artists;
            while (cursor.moveToNext()) {
                Artist artist = new Artist();
                artist.setId(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists._ID)));
                artist.setName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST)));
                artist.setCount(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS)));
                artists.add(artist);
            }
            return artists;
        } finally {
            if (null != cursor && !cursor.isClosed())
                cursor.close();
        }
    }

}
