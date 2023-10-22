package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.data.datasource.MovieCacheDataSource
import com.hisham.moviesapp.data.datasourceimpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModel {
    @Singleton
    @Provides
    fun getCacheDataSourceInstance(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}