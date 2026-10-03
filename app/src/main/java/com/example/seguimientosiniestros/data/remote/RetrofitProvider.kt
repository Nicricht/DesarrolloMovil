package com.example.seguimientosiniestros.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    fun crear(
        baseUrl: String = ApiConfig.BASE_URL
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun crearSiniestroApi(
        baseUrl: String = ApiConfig.BASE_URL
    ): SiniestroApiService =
        crear(baseUrl).create(SiniestroApiService::class.java)
}
