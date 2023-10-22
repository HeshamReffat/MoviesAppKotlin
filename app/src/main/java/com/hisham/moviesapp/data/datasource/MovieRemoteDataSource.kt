package com.hisham.moviesapp.data.datasource

import com.hisham.moviesapp.data.model.Movie
import com.hisham.moviesapp.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}