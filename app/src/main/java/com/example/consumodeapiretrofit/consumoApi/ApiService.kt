package com.example.consumodeapiretrofit.consumoApi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    fun get(): Call<List<modelo>>
}