package com.hisham.moviesapp.data

import com.hisham.moviesapp.data.datasource.MovieCacheDataSource
import com.hisham.moviesapp.data.datasource.MovieLocalDataSource
import com.hisham.moviesapp.data.datasource.MovieRemoteDataSource
import com.hisham.moviesapp.data.model.Movie
import com.hisham.moviesapp.domain.usecases.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getAllMovies(): List<Movie>? {
        return getMoviesFromCache()
    }


    override suspend fun updateMovies(): List<Movie>? {
        val moviesList = getMoviesFromApi()
        movieLocalDataSource.deleteMoviesFromDb()
        movieLocalDataSource.saveMoviesToDB(moviesList)
        movieCacheDataSource.saveMoviesToCache(moviesList)
        return moviesList
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (error: Exception) {

        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDb()
        } catch (error: Exception) {

        }
        return if (movieList.isNotEmpty()) {
            movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
            movieList
        }
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (error: Exception) {
        }
        return if (movieList.isNotEmpty()) {
            movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
            movieList
        }
    }
}