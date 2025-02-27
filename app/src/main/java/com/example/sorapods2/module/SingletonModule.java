package com.example.sorapods2.module;

import android.content.Context;

import androidx.room.Room;

import com.example.sorapods2.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class SingletonModule {
    private static final String DB_NAME = "sora_db";

    @Provides
    @Singleton
    public AppDatabase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }
}
