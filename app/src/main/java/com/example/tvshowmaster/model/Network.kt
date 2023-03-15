package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Network(
    val country: Country,
    val id: Int,
    val name: String,
    val officialSite: String
) : Parcelable