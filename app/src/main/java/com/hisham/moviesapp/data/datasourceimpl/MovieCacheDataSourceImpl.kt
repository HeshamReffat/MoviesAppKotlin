package com.hisham.moviesapp.data.datasourceimpl

import com.hisham.moviesapp.data.datasource.MovieCacheDataSource
import com.hisham.moviesapp.data.db.MovieDao
import com.hisham.moviesapp.data.model.Movie

class MovieCacheDataSourceImpl() : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}