package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.data.api.TMDBService
import com.hisham.moviesapp.data.datasource.MovieRemoteDataSource
import com.hisham.moviesapp.data.datasourceimpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun getRemoteDataSourceInstance(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }
}