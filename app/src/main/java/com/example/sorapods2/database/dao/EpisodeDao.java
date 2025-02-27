package com.example.sorapods2.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.sorapods2.database.entity.Episode;

@Dao
public interface EpisodeDao {
    @Insert
    void insertAll(Episode... episodes);
}
