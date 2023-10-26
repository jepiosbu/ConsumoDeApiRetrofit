package com.example.consumodeapiretrofit.consumoApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    var retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:8000/api/").addConverterFactory(GsonConverterFactory.create()).build()
    var service = retrofit.create(ApiService::class.java)
}