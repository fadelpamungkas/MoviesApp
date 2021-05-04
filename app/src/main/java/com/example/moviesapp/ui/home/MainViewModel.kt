package com.example.moviesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.repository.Repository

class MainViewModel(private val repository: Repository = AppRepository()) : ViewModel() {

    fun getMovie() : LiveData<ArrayList<Movie>>  = repository.getPopularMovies()

    fun getTVShow() : LiveData<ArrayList<TVShow>> = repository.getPopularTVs()

}