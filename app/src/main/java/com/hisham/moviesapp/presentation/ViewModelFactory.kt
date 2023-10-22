package com.hisham.moviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hisham.moviesapp.domain.usecases.GetMoviesUseCase
import com.hisham.moviesapp.domain.usecases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(
                getMoviesUseCase,
                updateMoviesUseCase
            ) as T
        }
        throw IllegalArgumentException("Wrong View Model")
    }
}