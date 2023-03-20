package com.example.tvshowappmaster.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponseItem(
    val _links: Links,
    val averageRuntime: Int,
    val ended: String,
    val externals: Externals,
    val genres: List<String>,
    val id: Int,
    val image: Image,
    val language: String,
    val name: String,
    val network: Network,
    val officialSite: String,
    val premiered: String,
    val rating: Rating,
    val runtime: Int,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int,
    val url: String,
    val weight: Int
) : Parcelable
