package com.yq.yunmusic.http.response;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertSingleBlog(BlogBean bean);

    /**
     * 编译报错；
     * Methods annotated with @Insert can return either void, long, Long, long[], Long[] or List<Long>
     * 原因不详
     *
     * @param
     * @return 行 id
     * <p>
     * Flowable<Long> insertBlog(BlogBean blog);
     */

    @Query("SELECT * FROM blog")
    public abstract Flowable<List<BlogBean>> findAll();

    @Query("SELECT * FROM blog")
    public abstract List<BlogBean> getAllBlogs();

    @Query("SELECT * FROM blog WHERE _id = :id")
    public abstract Flowable<BlogBean> queryBlogById(String id);

}
