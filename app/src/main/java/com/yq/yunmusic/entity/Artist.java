package com.yq.yunmusic.entity;

/**
 * 歌手信息类
 */
public class Artist {

    private int id;//ID
    private String name;//歌手名字
    private int count;//专辑数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
