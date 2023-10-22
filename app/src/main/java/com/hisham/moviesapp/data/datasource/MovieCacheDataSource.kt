package com.hisham.moviesapp.data.datasource

import com.hisham.moviesapp.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}