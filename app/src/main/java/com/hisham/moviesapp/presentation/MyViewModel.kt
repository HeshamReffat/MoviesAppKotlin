package com.hisham.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hisham.moviesapp.domain.usecases.GetMoviesUseCase
import com.hisham.moviesapp.domain.usecases.UpdateMoviesUseCase

class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovie() = liveData {
        val moviesList = updateMoviesUseCase.execute()
        emit(moviesList)
    }
}