package com.example.moviesapp.repository

import android.os.Handler
import android.os.Looper
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.utils.EspressoIdlingResource

class FakeRemoteData private constructor(private val dataDummy: DataDummy) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: FakeRemoteData? = null

        fun getInstance(data: DataDummy): FakeRemoteData =
                instance ?: synchronized(this) {
                    FakeRemoteData(data).apply { instance = this }
                }
    }

    fun getPopularMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(dataDummy.generateDummyMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getPopularTVShow(callback: LoadTVShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTVShowReceived(dataDummy.generateDummyTVShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieContent(moduleId: Int, callback: LoadMovieContentCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            lateinit var data : Movie
            dataDummy.generateDummyMovies().forEach { movie ->
                if ( movie.id == moduleId) {
                    data = movie
                }
            }
            callback.onContentReceived(data)
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTVContent(moduleId: Int, callback: LoadTVContentCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            lateinit var data : TVShow
            dataDummy.generateDummyTVShow().forEach { tv ->
                if ( tv.id == moduleId) {
                    data = tv
                }
            }
            callback.onContentReceived(data)
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<Movie>)
    }

    interface LoadTVShowCallback {
        fun onAllTVShowReceived(tvshowResponses: List<TVShow>)
    }

    interface LoadMovieContentCallback {
        fun onContentReceived(movieResponse: Movie)
    }

    interface LoadTVContentCallback {
        fun onContentReceived(tvshowResponse: TVShow)
    }

}
