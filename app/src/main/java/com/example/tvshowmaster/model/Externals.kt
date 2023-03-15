package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Externals(
    val imdb: String,
    val thetvdb: Int,
    val tvrage: Int
) : Parcelable