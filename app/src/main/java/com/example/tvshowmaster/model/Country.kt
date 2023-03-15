package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val code: String,
    val name: String,
    val timezone: String
) : Parcelable