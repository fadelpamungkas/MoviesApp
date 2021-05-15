package com.example.moviesapp.repository.localsource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow

@Database(entities = [Movie::class, TVShow::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDAO(): AppDAO

}