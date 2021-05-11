package com.example.moviesapp.repository

import androidx.lifecycle.LiveData
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow

interface Repository {

    fun getPopularMovies() : LiveData<ArrayList<Movie>>

    fun getPopularTVs() : LiveData<ArrayList<TVShow>>

    fun getDetailMovie(id : Int) : LiveData<Movie>

    fun getDetailTV(id : Int) : LiveData<TVShow>
}