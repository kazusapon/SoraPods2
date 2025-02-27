package com.example.sorapods2.database.repository;

import com.example.sorapods2.database.AppDatabase;
import com.example.sorapods2.database.dao.PodcastDao;
import com.example.sorapods2.database.entity.Podcast;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import lombok.val;

public class PodcastRepository {
    private final PodcastDao podcastDao;
    private final ExecutorService executorService;

    @Inject
    public PodcastRepository(AppDatabase appDatabase) {
        this.podcastDao = appDatabase.podcastDao();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void insertAll(List<Podcast> podcasts) {
        try {
            executorService.execute(() -> {
                this.podcastDao.insertAll(podcasts);
            });
        } finally {
            executorService.shutdown();
        }
    }

    public int getPodcastCount() {
        val podcastCount = executorService.submit(podcastDao::getCount);
        try {
            return podcastCount.get();
        } catch (ExecutionException e) {
            return 0;
        } catch (InterruptedException e) {
            return 0;
        }
    }
}
