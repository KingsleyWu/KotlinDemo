package com.qooapp.kotlin.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpHelper {

    // Declaration has type inferred from a platform call, which can lead to unchecked nullability issues. Specify type explicitly as nullable or non-nullable.

    val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

}