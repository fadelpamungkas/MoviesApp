package com.example.moviesapp.repository.remotesource

import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.PopularMovies
import com.example.moviesapp.model.PopularTVShow
import com.example.moviesapp.model.TVShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequest {

    @GET("/3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<PopularMovies>

    @GET("/3/movie/{movie_id}")
    fun getDetailMovie(@Path("movie_id") id: Int, @Query("api_key") apiKey: String): Call<Movie>

    @GET("/3/tv/popular")
    fun getPopularTVs(@Query("api_key") apiKey: String): Call<PopularTVShow>

    @GET("/3/tv/{tv_id}")
    fun getDetailTV(@Path("tv_id") id: Int, @Query("api_key") apiKey: String): Call<TVShow>

}