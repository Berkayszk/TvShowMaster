package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DvdCountry(
    val code: String,
    val name: String,
    val timezone: String
) : Parcelable