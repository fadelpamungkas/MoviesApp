package com.example.moviesapp.model

import com.google.gson.annotations.SerializedName

data class PopularTVShow(
    @SerializedName("results")
    val result: ArrayList<TVShow>
)
