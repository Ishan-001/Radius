package com.example.radius.data.network.service

import com.example.radius.data.model.RadiusResponse
import retrofit2.Response
import retrofit2.http.GET

interface RadiusService {

    @GET("db")
    suspend fun getFacilities(): Response<RadiusResponse>
}