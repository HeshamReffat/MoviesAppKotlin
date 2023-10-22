package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.data.MovieRepositoryImpl
import com.hisham.moviesapp.data.datasource.MovieCacheDataSource
import com.hisham.moviesapp.data.datasource.MovieLocalDataSource
import com.hisham.moviesapp.data.datasource.MovieRemoteDataSource
import com.hisham.moviesapp.domain.usecases.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) {
    @Singleton
    @Provides
    fun getRepositoryInstance(): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
}