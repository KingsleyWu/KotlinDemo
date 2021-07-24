package com.qooapp.kotlin.spring.utils

// 亂寫的，別用
object SpringContextUtils {
    private var mSpringContext: SpringContext?= null

    fun setSpringContext(springContext: SpringContext){
        mSpringContext = springContext
    }

    fun isProd() = mSpringContext?.isProd() ?: throw NullPointerException("SpringContext is null")
}