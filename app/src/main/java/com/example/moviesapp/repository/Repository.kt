package com.example.moviesapp.repository

import androidx.lifecycle.LiveData
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow

interface Repository {

    fun getPopularMovies() : LiveData<ArrayList<Movie>>

    fun getPopularTVs() : LiveData<ArrayList<TVShow>>

    fun getDetailMovie(id : Int) : LiveData<Movie>

    fun getDetailTV(id : Int) : LiveData<TVShow>

    fun getAllMovieFromDatabase() : LiveData<ArrayList<Movie>>

    fun getALlTVShowFromDatabase() : LiveData<ArrayList<TVShow>>

    fun findMovieFromDatabase(id: Int) : LiveData<Movie>?

    fun findTVShowFromDatabase(id: Int) : LiveData<TVShow>?

    suspend fun deleteMovie(id: Int)

    suspend fun deleteTVShow(id: Int)

    suspend fun insert(movie: Movie)

    suspend fun insert(tvShow: TVShow)
}