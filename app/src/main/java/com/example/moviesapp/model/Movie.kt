package com.example.moviesapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    var photo: Int = 0,
    var title: String? = null,
    var rating: String? = null,
    var release: String? = null,
    var runtime: String? = null,
    var genre: String? = null,
    var description: String? = null
) : Parcelable