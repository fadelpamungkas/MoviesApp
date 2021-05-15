package com.example.moviesapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow

interface Repository {

    fun getPopularMovies() : LiveData<ArrayList<Movie>>

    fun getPopularTVs() : LiveData<ArrayList<TVShow>>

    fun getDetailMovie(id : Int) : LiveData<Movie>

    fun getDetailTV(id : Int) : LiveData<TVShow>

    fun getAllMovieFromDatabase(sort: String) : DataSource.Factory<Int, Movie>

    fun getALlTVShowFromDatabase(sort: String) : DataSource.Factory<Int, TVShow>

    fun findMovieFromDatabase(id: Int) : LiveData<Movie>?

    fun findTVShowFromDatabase(id: Int) : LiveData<TVShow>?

    suspend fun deleteMovie(id: Int)

    suspend fun deleteTVShow(id: Int)

    suspend fun insert(movie: Movie)

    suspend fun insert(tvShow: TVShow)
}