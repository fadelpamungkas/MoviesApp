package com.example.moviesapp.model

import com.google.gson.annotations.SerializedName

data class PopularMovies(
    @SerializedName("results")
    val result: ArrayList<Movie>
)
