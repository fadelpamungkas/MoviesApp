package com.example.moviesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviesapp.BuildConfig
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.PopularMovies
import com.example.moviesapp.model.PopularTVShow
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.localsource.AppDAO
import com.example.moviesapp.repository.remotesource.ApiRequest
import com.example.moviesapp.utils.EspressoIdlingResource
import com.example.moviesapp.utils.SortUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val appDAO: AppDAO, 
    private val apiRequest: ApiRequest
    ) : Repository{

    private val _responsePopularMovie = MutableLiveData<ArrayList<Movie>>()
    private val _responsePopularTV = MutableLiveData<ArrayList<TVShow>>()
    private val _responseDetailMovie = MutableLiveData<Movie>()
    private val _responseDetailTV = MutableLiveData<TVShow>()

//    private val _movieDatabase = appDAO.getAllMovieFromDatabase()
//    private val _tvShowDatabase = appDAO.getAllTVShowFromDatabase()
    private var _findMovieDatabase: LiveData<Movie>? = null
    private var _findTVShowDatabase: LiveData<TVShow>? = null

    override fun getPopularMovies() : LiveData<ArrayList<Movie>>{
        EspressoIdlingResource.increment()
        apiRequest.getPopularMovies(BuildConfig.API_KEY).enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful) {
                    _responsePopularMovie.postValue(response.body()?.result)

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }

                }
            }

            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Log.e("getPopularMovies: ", t.message.toString())
            }

        })
        return _responsePopularMovie
    }

    override fun getDetailMovie(id : Int) : LiveData<Movie> {
        EspressoIdlingResource.increment()
        apiRequest.getDetailMovie(id, BuildConfig.API_KEY).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    _responseDetailMovie.postValue(response.body())

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e("getDetailMovie: ", t.message.toString())
            }

        })

        return _responseDetailMovie
    }

    override fun getPopularTVs() : LiveData<ArrayList<TVShow>>{
        EspressoIdlingResource.increment()
        apiRequest.getPopularTVs(BuildConfig.API_KEY).enqueue(object : Callback<PopularTVShow> {
            override fun onResponse(call: Call<PopularTVShow>, response: Response<PopularTVShow>) {
                if (response.isSuccessful) {
                    _responsePopularTV.postValue(response.body()?.result)

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<PopularTVShow>, t: Throwable) {
                Log.e("getPopularTVs: ", t.message.toString())
            }

        })

        return _responsePopularTV
    }

    override fun getDetailTV(id : Int) : LiveData<TVShow> {
        EspressoIdlingResource.increment()
        apiRequest.getDetailTV(id, BuildConfig.API_KEY).enqueue(object : Callback<TVShow> {
            override fun onResponse(call: Call<TVShow>, response: Response<TVShow>) {
                if (response.isSuccessful) {
                    _responseDetailTV.postValue(response.body())

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<TVShow>, t: Throwable) {
                Log.e("getDetailTV: ", t.message.toString())
            }

        })

        return _responseDetailTV
    }

    override fun getAllMovieFromDatabase(sort: String): DataSource.Factory<Int, Movie> {
        val query = SortUtils.getSortedQuery(SortUtils.TYPE_MOVIE, sort)
        return appDAO.getAllMovieFromDatabase(query)
    }

    override fun getALlTVShowFromDatabase(sort: String): DataSource.Factory<Int, TVShow> {
        val query = SortUtils.getSortedQuery(SortUtils.TYPE_TVSHOW, sort)
        return appDAO.getAllTVShowFromDatabase(query)
    }

    override fun findMovieFromDatabase(id: Int): LiveData<Movie>? {
        _findMovieDatabase = appDAO.findMovieFromDatabase(id)
        return _findMovieDatabase
    }

    override fun findTVShowFromDatabase(id: Int): LiveData<TVShow>? {
        _findTVShowDatabase = appDAO.findTVShowFromDatabase(id)
        return _findTVShowDatabase
    }

    override suspend fun deleteMovie(id: Int) {
        appDAO.deleteMovie(id)
    }

    override suspend fun deleteTVShow(id: Int) {
        appDAO.deleteTVShow(id)
    }

    override suspend fun insert(movie: Movie) {
        appDAO.insert(movie)
    }

    override suspend fun insert(tvShow: TVShow) {
        appDAO.insert(tvShow)
    }
}