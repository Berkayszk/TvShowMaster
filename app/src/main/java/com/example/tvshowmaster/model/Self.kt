package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Self(
    val href: String
) : Parcelable