package com.example.moviesapp.di

import android.content.Context
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.repository.localsource.AppDatabase

object Injection {
    fun provideRepository(context: Context): AppRepository {
        val database = AppDatabase.getInstance(context).appDAO()

        return AppRepository(database)
    }
}