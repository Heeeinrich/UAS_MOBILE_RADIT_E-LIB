package com.example.uasmobileradite_lib

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://ppbo-api.vercel.app/"

    fun <T> createService(service: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Make sure GsonConverterFactory is properly imported
            .build()
        return retrofit.create(service)
    }
}
