package com.hisham.moviesapp.data.datasourceimpl

import com.hisham.moviesapp.data.datasource.MovieLocalDataSource
import com.hisham.moviesapp.data.db.MovieDao
import com.hisham.moviesapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val dao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> = dao.getAllMovies()

    override suspend fun deleteMoviesFromDb() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllMovies()
        }
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertMovies(movies)
        }
    }
}