package com.qooapp.kotlin.example.part2

// 函数声明
// 声明函数要用 fun 关键字
// 函数的「返回值」在「函数参数」右边使用 : 分隔，没有返回值时可以省略
fun sum(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

// 如只有一行，可以使用 = 替换 return
fun sum2(arg1: Int, arg2: Int) = arg1 + arg2

// 把函数声明成一个变量
val sum3 = fun(arg1: Int, arg2: Int) = arg1 + arg2

// 局部方法，不建议在循环的方法中使用！！！！！！
fun methodA(arg: Int) {
    println("arg $arg")
    fun methodB(any: Any) {
        println("any $any")
    }
    for (i in 0..4) {
        methodB(i)
    }
}

fun main() {
    println(sum(1, 2))
    println(sum2(1, 2))
    println(sum3(1, 2))

    methodA(1)

    val inline = "inline"
    println(inline.inline<Any>())
    println(inline.inline<Int>())
}


// inline 函数 内联函数
inline fun <reified T> String.inline(): String {
    return "${T::class.java.simpleName} $this"
}