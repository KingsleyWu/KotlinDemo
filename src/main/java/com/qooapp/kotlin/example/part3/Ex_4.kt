package com.qooapp.kotlin.example.part3

// 扩展函数
fun Companion.getName() = "name"

// 扩展属性
val Companion.instance: Companion
    get() = Companion.getCompanion()

// 为可空的类型定义扩展函数
fun Any?.toString() : String{
    if (this == null) return "null"
    return toString()
}
