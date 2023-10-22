package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.domain.usecases.GetMoviesUseCase
import com.hisham.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.hisham.moviesapp.domain.usecases.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun getMovieUseCaseInstance(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun updateMoviesUseCaseInstance(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}