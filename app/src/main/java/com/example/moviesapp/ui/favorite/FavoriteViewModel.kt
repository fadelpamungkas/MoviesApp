package com.example.moviesapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: AppRepository): ViewModel() {

    private val _databaseMovie: LiveData<ArrayList<Movie>> = repository.getAllMovieFromDatabase()
    private val _databaseTVShow: LiveData<ArrayList<TVShow>> = repository.getALlTVShowFromDatabase()
    private var _findMovie: LiveData<Movie>? = null
    private var _findTVShow: LiveData<TVShow>? = null

    fun deleteMovie(id: Int) = viewModelScope.launch { repository.deleteMovie(id) }

    fun deleteTVShow(id: Int) = viewModelScope.launch { repository.deleteTVShow(id) }

    fun findMovie(id: Int): LiveData<Movie>? {
        _findMovie = repository.findMovieFromDatabase(id)
        return _findMovie
    }

    fun findTVShow(id: Int): LiveData<TVShow>? {
        _findTVShow = repository.findTVShowFromDatabase(id)
        return _findTVShow
    }

    fun getAllMovies(): LiveData<ArrayList<Movie>> = _databaseMovie

    fun getAllTVShows(): LiveData<ArrayList<TVShow>> = _databaseTVShow
}