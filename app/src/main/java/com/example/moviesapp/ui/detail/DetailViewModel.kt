package com.example.moviesapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository

class DetailViewModel : ViewModel() {

    private val repository: AppRepository = AppRepository()

    private var id: Int = 0

    fun setSelectedData(id: Int) {
        this.id = id
    }

    fun getSelectedMovie() : LiveData<Movie> {
        return repository.getDetailMovie(id)
    }
    fun getSelectedTVShow() : LiveData<TVShow> {
        return repository.getDetailTV(id)
    }
}