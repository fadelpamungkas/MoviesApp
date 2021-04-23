package com.example.moviesapp.ui

import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.utils.DataDummy

class DetailViewModel : ViewModel() {

    var id: Int = 0

    fun setSelectedCourse(id: Int) {
        this.id = id
    }

    fun getCourse(): Movie? {
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