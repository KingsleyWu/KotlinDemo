package com.qooapp.kotlin.example.part2

import kotlin.random.Random

fun main() {
    // if 操作符
    if (condition() == 1) {
        println("符合条件")
    } else {
        println("不符合条件")
    }
    println(
        if (condition() == 1) {
            "符合条件"
        } else {
            "不符合条件"
        }
    )
    // 省略大括号
    println(if (condition() == 1) "符合条件" else "不符合条件")

    // 可以通过 ?: 的操作来简化 if null 的操作
    var arg: Any? = ""
    println(arg?.toString() ?: "null")

    val condition = condition()
    // when 操作符
    when (condition) {
        is Int -> println("condition is Int $condition")
        in 1..5 -> println("condition is in 1..5")
        "1".toInt() -> println("condition is 1")
        else -> println("condition is $condition")
    }
    val result = when {
        condition in 1..5 -> 5
        condition == "1".toInt() -> 1
        else -> 0
    }
    println(result)
}

fun condition() = Random(1).nextInt()

