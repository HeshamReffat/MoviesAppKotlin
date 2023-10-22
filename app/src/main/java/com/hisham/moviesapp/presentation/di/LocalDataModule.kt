package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.data.datasource.MovieLocalDataSource
import com.hisham.moviesapp.data.datasourceimpl.MovieLocalDataSourceImpl
import com.hisham.moviesapp.data.db.MovieDao
import com.hisham.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun getLocalDataSourceInstance(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}