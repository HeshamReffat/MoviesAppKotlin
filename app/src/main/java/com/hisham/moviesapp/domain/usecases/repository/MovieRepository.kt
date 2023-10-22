package com.hisham.moviesapp.domain.usecases.repository

import com.hisham.moviesapp.data.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}