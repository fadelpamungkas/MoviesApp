package com.example.moviesapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.repository.Repository

class DetailViewModel(private val repository: Repository = AppRepository()) : ViewModel() {

    private lateinit var movieData : LiveData<Movie>
    private lateinit var tvShowData : LiveData<TVShow>

    fun setSelectedMovie(id: Int) { movieData = repository.getDetailMovie(id) }

    fun setSelectedTV(id: Int) { tvShowData = repository.getDetailTV(id) }

    fun getSelectedMovie() : LiveData<Movie> = movieData

    fun getSelectedTVShow() : LiveData<TVShow> = tvShowData
}