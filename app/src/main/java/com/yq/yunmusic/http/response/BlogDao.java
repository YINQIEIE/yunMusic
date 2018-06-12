package com.yq.yunmusic.http.response;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public abstract class BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertSingleBlog(BlogBean bean);

    @Insert
    public abstract void insertBlog(BlogBean... blog);

    @Query("select * from blog")
    public abstract List<BlogBean> findAll();
}
