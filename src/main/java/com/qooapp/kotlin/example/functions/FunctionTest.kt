package com.qooapp.kotlin.example.functions

// 高阶函数 -》把函数作为参数或者返回值的一类函数，指的是它的参数或返回值有些特别
fun main() {
    val list = mutableListOf(1,2,3,4,5,6,7)
    list.forEach { println(it) }

    // 函数引用
    list.forEach(::println)
    // 函数声明
    val filter = {i: Int -> i % 2 == 0}
    list.filter(filter)

}

// 内部实现
// @kotlin.internal.HidesMember
// public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
//   for (element in this) action(element)
// }
