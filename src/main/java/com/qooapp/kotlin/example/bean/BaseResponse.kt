package com.qooapp.kotlin.example.bean

data class BaseResponse<T>(var code: Int, var message: String?, var data: T)