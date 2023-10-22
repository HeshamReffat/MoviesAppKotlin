package com.hisham.moviesapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity(tableName = "popular_movies")
data class Movie(
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
)