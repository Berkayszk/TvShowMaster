package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WebChannel(
    val country: Country,
    val id: Int,
    val name: String,
    val officialSite: String
) : Parcelable