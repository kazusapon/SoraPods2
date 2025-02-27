package com.example.sorapods2.service;

import com.example.sorapods2.database.entity.Podcast;
import com.example.sorapods2.database.repository.PodcastRepository;

import java.util.ArrayList;
import java.util.concurrent.Future;

import javax.inject.Inject;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.components.SingletonComponent;
import lombok.val;

@Module
@InstallIn(SingletonComponent.class)
public class InitialDataService {
    private static final int MAX_PODCAST_SIZE = 4;
    private static final String REBUILD_RSS_FEED = "https://feeds.rebuild.fm/rebuildfm";
    private static final String MISREADING_RSS_FEED = "https://misreading.chat/category/episodes/feed/";
    private static final String COTEN_RSS_FEED = "https://anchor.fm/s/8c2088c/podcast/rss";
    private static final String HIMAJIN_RSS_FEED = "https://rss.art19.com/07ef6b45-d4fc-4d94-b211-e02a27b7e2a6";

    private final PodcastRepository podcastRepository;

    @Inject
    public InitialDataService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public void insertInitialPodcasts() {
        if (podcastRepository.getPodcastCount() >= MAX_PODCAST_SIZE) {
            return;
        }

        val podcasts = new ArrayList<Podcast>();
        podcasts.add(buildRebuildRecord());
        podcasts.add(buildMisreadingRecord());
        podcasts.add(buildCotenRecord());
        podcasts.add(buildHimajinRecord());

        podcastRepository.insertAll(podcasts);
    }

    private Podcast buildRebuildRecord() {
        val podcast = new Podcast();
        podcast.name = "Rebuild.fm";
        podcast.url = REBUILD_RSS_FEED;

        return podcast;
    }

    private Podcast buildMisreadingRecord() {
        val podcast = new Podcast();
        podcast.name = "MisreadingChat";
        podcast.url = MISREADING_RSS_FEED;

        return podcast;
    }

    private Podcast buildCotenRecord() {
        val podcast = new Podcast();
        podcast.name = "COTEN RADIO";
        podcast.url = COTEN_RSS_FEED;

        return podcast;
    }

    private Podcast buildHimajinRecord() {
        val podcast = new Podcast();
        podcast.name = "ひまじんプログラマー";
        podcast.url = HIMAJIN_RSS_FEED;

        return podcast;
    }
}
