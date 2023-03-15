package com.example.tvshowmaster.api

import com.example.tvshowappmaster.model.PeopleResponse
import com.example.tvshowappmaster.model.TvShowResponse
import com.example.tvshowmaster.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    fun getTvShows() : Response<TvShowResponse>

    @GET(Constants.PEOPLE_POINT)
    fun getPeople(): Response<PeopleResponse>
}