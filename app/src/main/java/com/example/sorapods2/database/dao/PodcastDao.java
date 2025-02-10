package com.example.sorapods2.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sorapods2.database.entity.Podcast;

import java.util.List;

@Dao
public interface PodcastDao {
    @Insert
    void insertAll(List<Podcast> podcasts);

    @Query("SELECT COUNT(*) FROM podcasts")
    Integer getCount();
}
