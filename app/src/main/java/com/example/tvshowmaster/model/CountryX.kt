package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryX(
    val code: String,
    val name: String,
    val timezone: String
) : Parcelable