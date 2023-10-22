package com.hisham.moviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hisham.moviesapp.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun dao(): MovieDao

}