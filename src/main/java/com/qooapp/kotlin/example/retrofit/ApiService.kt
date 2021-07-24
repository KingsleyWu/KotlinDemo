package com.qooapp.kotlin.example.retrofit

import com.qooapp.kotlin.example.bean.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/auto-test/projects")
    suspend fun getProjects(): BaseResponse<List<Any>>
}