package com.example.moviesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository

class MainViewModel : ViewModel() {

    private val repository: AppRepository = AppRepository()
    private val listMovies: LiveData<ArrayList<Movie>>
    private val listTVShows: LiveData<ArrayList<TVShow>>

    init {
        repository.getPopularMovies()
        repository.getPopularTVs()
        listMovies = repository.responseMovie
        listTVShows = repository.responseTVShow
    }


    fun getMovie() : LiveData<ArrayList<Movie>> {
        return listMovies
    }

    fun getTVShow() : LiveData<ArrayList<TVShow>> {
        return listTVShows
    }

}