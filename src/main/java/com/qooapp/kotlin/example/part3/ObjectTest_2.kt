package com.qooapp.kotlin.example.part3

// kotlin 单例模式
object Util {
    fun checkIsNull(arg: Any?) = arg == null
}

fun main() {
    Util.checkIsNull(null)
    SingletonUtil_2.getInstance().checkIsNull(null)
}