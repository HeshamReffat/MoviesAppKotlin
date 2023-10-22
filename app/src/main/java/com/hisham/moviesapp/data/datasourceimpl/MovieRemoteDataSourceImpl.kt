package com.hisham.moviesapp.data.datasourceimpl

import com.hisham.moviesapp.data.api.TMDBService
import com.hisham.moviesapp.data.datasource.MovieRemoteDataSource
import com.hisham.moviesapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}