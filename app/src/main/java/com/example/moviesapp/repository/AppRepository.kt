package com.example.moviesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.BuildConfig
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.PopularMovies
import com.example.moviesapp.model.PopularTVShow
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.remotesource.RetrofitClient
import com.example.moviesapp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository : Repository{

    override fun getPopularMovies(): LiveData<ArrayList<Movie>> {
        val responseMovie = MutableLiveData<ArrayList<Movie>>()
        EspressoIdlingResource.increment()
        RetrofitClient.create().getPopularMovies(BuildConfig.API_KEY).enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful) {
                    responseMovie.postValue(response.body()?.result)

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }

                }
            }

            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Log.e("getPopularMovies: ", t.message.toString())
            }

        })
        return responseMovie
    }

    override fun getDetailMovie(id : Int) : LiveData<Movie> {
        val responseData = MutableLiveData<Movie>()
        EspressoIdlingResource.increment()
        RetrofitClient.create().getDetailMovie(id, BuildConfig.API_KEY).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    responseData.postValue(response.body())

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e("getDetailMovie: ", t.message.toString())
            }

        })

        return responseData
    }

    override fun getPopularTVs(): LiveData<ArrayList<TVShow>> {
        val responseTVShow = MutableLiveData<ArrayList<TVShow>>()
        EspressoIdlingResource.increment()
        RetrofitClient.create().getPopularTVs(BuildConfig.API_KEY).enqueue(object : Callback<PopularTVShow> {
            override fun onResponse(call: Call<PopularTVShow>, response: Response<PopularTVShow>) {
                if (response.isSuccessful) {
                    responseTVShow.postValue(response.body()?.result)

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<PopularTVShow>, t: Throwable) {
                Log.e("getPopularTVs: ", t.message.toString())
            }

        })
        return responseTVShow
    }

    override fun getDetailTV(id : Int) : LiveData<TVShow> {
        val responseData = MutableLiveData<TVShow>()
        EspressoIdlingResource.increment()
        RetrofitClient.create().getDetailTV(id, BuildConfig.API_KEY).enqueue(object : Callback<TVShow> {
            override fun onResponse(call: Call<TVShow>, response: Response<TVShow>) {
                if (response.isSuccessful) {
                    responseData.postValue(response.body())

                    if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<TVShow>, t: Throwable) {
                Log.e("getDetailTV: ", t.message.toString())
            }

        })

        return responseData
    }
}