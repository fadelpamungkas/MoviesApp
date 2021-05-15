package com.example.moviesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: AppRepository) : ViewModel() {

    private var movieData: LiveData<ArrayList<Movie>> = repository.getPopularMovies()
    private var tvShowData: LiveData<ArrayList<TVShow>> = repository.getPopularTVs()

    fun getMovie() : LiveData<ArrayList<Movie>> = movieData

    fun getTVShow() : LiveData<ArrayList<TVShow>> = tvShowData

}