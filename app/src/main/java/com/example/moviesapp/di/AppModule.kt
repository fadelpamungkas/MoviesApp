package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.repository.localsource.AppDAO
import com.example.moviesapp.repository.localsource.AppDatabase
import com.example.moviesapp.repository.remotesource.ApiRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideDAO(appDatabase: AppDatabase): AppDAO {
        return appDatabase.appDAO()
    }

    @Provides
    fun provideRepository(appDAO: AppDAO, apiRequest: ApiRequest): AppRepository {
        return AppRepository(appDAO, apiRequest)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "movie_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): ApiRequest {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/")
            .client(client)
            .build()
        return retrofit.create(ApiRequest::class.java)
    }
}