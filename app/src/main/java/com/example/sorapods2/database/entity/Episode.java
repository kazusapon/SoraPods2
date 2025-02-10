package com.example.sorapods2.database.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Episode {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "podcast_id")
    @NonNull
    public Integer podcastId;

    @ColumnInfo
    @NonNull
    public String title;

    @ColumnInfo
    @NonNull
    public String description;

    @ColumnInfo(name = "download_url")
    public String downloadUrl;

    @ColumnInfo(name = "playback_time")
    public String playbackTime;
}

