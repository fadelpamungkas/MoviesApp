package com.example.moviesapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShow(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    var photo: String? = null,
    @SerializedName("name")
    var title: String? = null,
    @SerializedName("vote_average")
    var rating: Float? = null,
    @SerializedName("first_air_date")
    var firstAirDate: String? = null,
    @SerializedName("number_of_episodes")
    var episodes: Int? = null,
    @SerializedName("overview")
    var description: String? = null
) : Parcelable