package com.example.moviesapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow


class FakeRepository (private val fakeRemoteData: FakeRemoteData) : Repository{

    companion object {
        @Volatile
        private var instance: FakeRepository? = null

        fun getInstance(remoteData: FakeRemoteData): FakeRepository =
                instance ?: synchronized(this) {
                    FakeRepository(remoteData).apply { instance = this }
                }
    }

    override fun getPopularMovies(): LiveData<ArrayList<Movie>> {
        val movieResults = MutableLiveData<ArrayList<Movie>>()
        fakeRemoteData.getPopularMovies(object : FakeRemoteData.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<Movie>) {
                val movieList = ArrayList<Movie>()
                for (response in movieResponses) {
                    val movie = Movie(response.id,
                            null,
                            response.title,
                            response.rating,
                            response.release,
                            response.runtime,
                            response.description)
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getPopularTVs(): LiveData<ArrayList<TVShow>> {
        val tvshowResults = MutableLiveData<ArrayList<TVShow>>()
        fakeRemoteData.getPopularTVShow(object : FakeRemoteData.LoadTVShowCallback {
            override fun onAllTVShowReceived(tvshowResponses: List<TVShow>) {
                val tvshowList = ArrayList<TVShow>()
                for (response in tvshowResponses) {
                    val tvShow = TVShow(response.id,
                            null,
                            response.title,
                            response.rating,
                            response.firstAirDate,
                            response.episodes,
                            response.description)
                    tvshowList.add(tvShow)
                }
                tvshowResults.postValue(tvshowList)
            }
        })

        return tvshowResults
    }

    override fun getDetailMovie(id: Int): LiveData<Movie> {
        val movieResult = MutableLiveData<Movie>()
        fakeRemoteData.getMovieContent(id, object : FakeRemoteData.LoadMovieContentCallback{
            override fun onContentReceived(movieResponse: Movie) {
                movieResult.postValue(movieResponse)
            }

        })
        return movieResult
    }

    override fun getDetailTV(id: Int): LiveData<TVShow> {
        val tvshowResults = MutableLiveData<TVShow>()
        fakeRemoteData.getTVContent(id, object : FakeRemoteData.LoadTVContentCallback{
            override fun onContentReceived(tvshowResponse: TVShow) {
                tvshowResults.postValue(tvshowResponse)
            }

        })

        return tvshowResults
    }
}

