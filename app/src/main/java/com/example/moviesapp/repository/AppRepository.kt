package com.example.moviesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.PopularMovies
import com.example.moviesapp.model.PopularTVShow
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.remotesource.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {
    private val API_KEY = "beefd9f1ed80ed60e6f79c23f322bd64"

    val responseMovie = MutableLiveData<ArrayList<Movie>>()
    val responseTVShow = MutableLiveData<ArrayList<TVShow>>()

    fun getPopularMovies(){
        RetrofitClient.create().getPopularMovies(API_KEY).enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful) {
                    responseMovie.postValue(response.body()?.result)
                }
            }

            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Log.e("getPopularMovies: ", t.message.toString())
            }

        })
    }

    fun getDetailMovie(id : Int) : LiveData<Movie> {
        val responseData = MutableLiveData<Movie>()
        RetrofitClient.create().getDetailMovie(id, API_KEY).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    responseData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e("getDetailMovie: ", t.message.toString())
            }

        })

        return responseData
    }

    fun getPopularTVs()  {
        RetrofitClient.create().getPopularTVs(API_KEY).enqueue(object : Callback<PopularTVShow> {

            override fun onResponse(call: Call<PopularTVShow>, response: Response<PopularTVShow>) {
                if (response.isSuccessful) {
                    responseTVShow.postValue(response.body()?.result)
                }
            }

            override fun onFailure(call: Call<PopularTVShow>, t: Throwable) {
                Log.e("getPopularTVs: ", t.message.toString())
            }

        })
    }

    fun getDetailTV(id : Int) : LiveData<TVShow> {
        val responseData = MutableLiveData<TVShow>()
        RetrofitClient.create().getDetailTV(id, API_KEY).enqueue(object : Callback<TVShow> {
            override fun onResponse(call: Call<TVShow>, response: Response<TVShow>) {
                if (response.isSuccessful) {
                    responseData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<TVShow>, t: Throwable) {
                Log.e("getDetailTV: ", t.message.toString())
            }

        })

        return responseData
    }
}