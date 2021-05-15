package com.example.moviesapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.repository.Repository
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: AppRepository) : ViewModel() {

    private lateinit var movieData : LiveData<Movie>
    private lateinit var tvShowData : LiveData<TVShow>
    private var _findMovie: LiveData<Movie>? = null
    private var _findTVShow: LiveData<TVShow>? = null

    fun setSelectedMovie(id: Int) { movieData = repository.getDetailMovie(id) }

    fun setSelectedTV(id: Int) { tvShowData = repository.getDetailTV(id) }

    fun getSelectedMovie() : LiveData<Movie> = movieData

    fun getSelectedTVShow() : LiveData<TVShow> = tvShowData

    fun insert(movie: Movie) = viewModelScope.launch { repository.insert(movie) }

    fun insert(tvShow: TVShow) = viewModelScope.launch { repository.insert(tvShow) }

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
}