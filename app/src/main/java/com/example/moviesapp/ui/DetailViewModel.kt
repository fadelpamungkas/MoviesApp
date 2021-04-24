package com.example.moviesapp.ui

import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.utils.DataDummy

class DetailViewModel : ViewModel() {

    private var id: Int = 0

    fun setSelectedData(id: Int) {
        this.id = id
    }

    fun getData(): Movie? {
        var movie: Movie? = null
        for (data in DataDummy.generateDummyMovies()) {
            if (data.id == id) {
                movie = data
            }
        }
        for (data in DataDummy.generateDummyTVShow()) {
            if (data.id == id) {
                movie = data
            }
        }
        return movie
    }
}