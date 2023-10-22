package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.domain.usecases.GetMoviesUseCase
import com.hisham.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.hisham.moviesapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun getViewModelFactoryInstance(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getMoviesUseCase, updateMoviesUseCase)

    }
}