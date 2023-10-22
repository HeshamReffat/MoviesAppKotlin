package com.hisham.moviesapp.domain.usecases

import com.hisham.moviesapp.data.model.Movie
import com.hisham.moviesapp.domain.usecases.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}