package com.example.moviesapp.ui

import androidx.lifecycle.ViewModel
import com.example.moviesapp.utils.DataDummy
import com.example.moviesapp.model.Movie

class MainViewModel : ViewModel() {

    fun getMovies() : List<Movie> = DataDummy.generateDummyMovies()

    fun getTVShow() : List<Movie> = DataDummy.generateDummyTVShow()
}