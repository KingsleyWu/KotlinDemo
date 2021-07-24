package com.qooapp.kotlin.example.part2

fun main() {
    try {
        val value = 1
        value as String
    } catch (e: Exception){
        println("出错了  ${e.message}")
    } finally {
        println("finally")
    }

    val result = try {
        val value = 1
        value as String
    } catch (e: Exception){
        println("出错了 ${e.message}")
        5
    } finally {
        println("finally")
    }
    println("result $result")
}
