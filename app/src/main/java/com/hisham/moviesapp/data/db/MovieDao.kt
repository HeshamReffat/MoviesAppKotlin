package com.hisham.moviesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hisham.moviesapp.data.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>)

    @Query("Delete From popular_movies")
    suspend fun deleteAllMovies()

    @Query("Select * From popular_movies")
    suspend fun getAllMovies(): List<Movie>
}