package com.example.moviesapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    var photo: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("vote_average")
    var rating: Float? = null,
    @SerializedName("release_date")
    var release: String? = null,
    @SerializedName("runtime")
    var runtime: Int? = null,
    @SerializedName("overview")
    var description: String? = null
) : Parcelable