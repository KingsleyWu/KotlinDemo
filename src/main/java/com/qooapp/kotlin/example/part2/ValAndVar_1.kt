package com.qooapp.kotlin.example.part2

// 变量声明
// ar 声明可读可写变量， val 声明只读变量
// 「类型」在「变量量名」的右边，用 : 分割，
// 同时如果满足「类型推断」，类 型可以省略

// 声明可读可写变量:
var age: Int = 18
var age2 = 18
// 声明只读变量:
val name: String = "Kotlin"
// 声明对象: 不需要 new 关键字
var any = Any()

fun arg(){
    println(age)
    println(age2)
    println(name)
    println(any)
}

val finalValue = "final value" // 运行时常量
const val constValue = "const value" // 编译期常量
var varValue = "var value" // 变量

fun main() {
    var aValue: String = "string"
    aValue = "string2" // 类型推导 String
    var bValue = "string3" + 5 // 类型推导 String
    val cValue = "string5"
    // Val cannot be reassigned
    // cValue = "xxxx"
    val eValue = finalValue
    val fValue = constValue
}

