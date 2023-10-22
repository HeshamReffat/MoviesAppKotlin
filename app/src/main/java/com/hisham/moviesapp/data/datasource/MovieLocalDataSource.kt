package com.hisham.moviesapp.data.datasource

import com.hisham.moviesapp.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb():List<Movie>
    suspend fun deleteMoviesFromDb()
    suspend fun saveMoviesToDB(movies:List<Movie>)
}