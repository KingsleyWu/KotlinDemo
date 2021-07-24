package com.qooapp.kotlin.example.part1

fun main() {
    // 区间
    val range: IntRange = 0..1024 // [0,1024
    val range2: IntRange = 0 until 1024 // [0,1023]  [0,1024)
    println(range.contains(100))
    println(100 in range)
    for (i in range2) {
        println(i)
    }

    // 數組
    val intArray: IntArray = intArrayOf(1,2,3)
    val stringArray: Array<String> = arrayOf("xx", "ss")
    for (s in stringArray) {
        println(s)
    }
    println(intArray[0])
}