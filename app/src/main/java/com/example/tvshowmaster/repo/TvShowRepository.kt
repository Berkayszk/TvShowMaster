package com.example.tvshowmaster.repo

import com.example.tvshowmaster.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(
private var apiService: ApiService
) {

    suspend fun getTvShow() = apiService.getTvShows()
    suspend fun getPeople() = apiService.getPeople()
}