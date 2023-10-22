package com.hisham.moviesapp.presentation.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hisham.moviesapp.data.db.MovieDao
import com.hisham.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getDataBaseInstance(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun getDaoInstance(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.dao()
    }
}