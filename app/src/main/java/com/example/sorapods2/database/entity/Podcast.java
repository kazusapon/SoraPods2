package com.example.sorapods2.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "podcasts")
public class Podcast {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo
    @NonNull
    public String name;

    @ColumnInfo
    @NonNull
    public String url;

    @ColumnInfo(name = "icon_image")
    public byte[] iconImage;
}
