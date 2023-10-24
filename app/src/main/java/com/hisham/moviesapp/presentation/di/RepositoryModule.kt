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
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource

    ):MovieRepository{

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    }

}