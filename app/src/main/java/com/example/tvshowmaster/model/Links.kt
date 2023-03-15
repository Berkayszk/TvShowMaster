package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
    val nextepisode: Nextepisode,
    val previousepisode: Previousepisode,
    val self: Self
) : Parcelable