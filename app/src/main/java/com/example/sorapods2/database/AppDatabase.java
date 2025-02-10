package com.example.sorapods2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sorapods2.database.dao.EpisodeDao;
import com.example.sorapods2.database.dao.PodcastDao;
import com.example.sorapods2.database.entity.Episode;
import com.example.sorapods2.database.entity.Podcast;

@Database(entities = { Podcast.class, Episode.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PodcastDao podcastDao();
    public abstract EpisodeDao episodeDao();
}
