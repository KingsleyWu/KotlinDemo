package com.qooapp.kotlin.example.part2

// 实际上就匿名函数
fun main() {
    val string = "xxxxxxx"
    // lambda 的最原始表达
    string.forEach({ char -> println(char) })

    // 如果函数的最后一个参数是 lambda ，
    // 那么 lambda 表达式可以放在圆括号之外:
    string.forEach() { char -> println(char) }
    // 如果函数入参数只有一个 lambda 的话，那么小括号可以省略的:
    string.forEach { char -> println(char) }
    // 如果 lambda 表达式只有一个参数，那么可以省略，通过隐式的 it 来访问
    string.forEach { println(it) }
    // :: 表示把 println 函数声明称一个变量传入
    string.forEach(::println)

    // 函数是有类型的 ！！！！
    println(sum(1, 2))
    println(sum)
    println(::function is () -> Unit)
    println(print is () -> Unit)
}

// lambada 的类型
// (Int, Int) -> Int     -》Function2
val sum = { arg1: Int, arg2: Int -> arg1 + arg2 }

// () -> Unit      -》Function0
val print = { print("xxxx") }

// () -> Unit      -》Function0
fun function() {}