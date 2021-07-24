package com.qooapp.kotlin.example.part2

fun main() {
    // for 循环
    forFun()
    // while , do .. while 循环
    whileAndDoWhile()
    // 跳过和终止循环
    breakFun()
    // 跳过和终止多层循环
    breakByLabel()
}

fun forFun() {
    val args = arrayOf(1, 2, 3, 4, 5)
    // for 循环
    for (arg in args) {
        println(arg)
    }
    println("for 循环 end \n")

    // for 循环
    args.forEach { println(it) }
    println("forEach end \n")

    // for 循环带 index
    for ((index, arg) in args.withIndex()) {
        println("index = $index , arg = $arg")
    }
    println("for withIndex end \n")

    // for 循环带 index
    args.forEachIndexed { index, arg ->
        println("index = $index , arg = $arg")
    }
    println("forEachIndexed end \n")

    // for 循环使用 iterator
    for (arg in args.iterator()) {
        println(arg)
    }

    println("for iterator end \n")
}

fun whileAndDoWhile() {
    val args = arrayOf(1, 2, 3, 4, 5)
    var index = 0

    // while 循环
    while (args[index] < 5) {
        println(args[index])
        index++
    }
    println("while end \n")

    // 我要回家，不要再初始化我了
    index = 0
    // do...while 循环
    do {
        println(args[index])
        index++
    } while (args[index] < 5)
    println("do...while end \n")
}

fun breakFun() {
    val args = arrayOf(1, 2, 3, 4, 5)
    for (arg in args) {
        // 继续下一个循环
        if (arg == 2) {
            println("continue end")
            continue
        }
        // 跳出循环
        if (arg == 4) {
            println("break end")
            break
        }
        println("arg = $arg")
    }
    println("breakFun end \n")
}

fun breakByLabel() {
    val args = arrayOf(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3, 4, 5))
    // 跳过和终止多层循环
    // Outer@ 外层标识，可以自定义
    Outer@ for (arrays in args) {
        var index = 0
        // Inner@ 内层标识，可以自定义
        Inner@ while (arrays[index] < 5) {
            if (arrays[index] == 4) {
                println("break@Outer end \n")
                break@Outer
            } else if (arrays[index] == 3) {
                println("continue@Inner end \n")
                index++
                continue@Inner
            } else if (arrays[index] == 1) {
                println("continue@Outer end \n")
                index++
                continue@Inner
            } else if (arrays[index] == 2) {
                println("break@Inner end \n")
                index++
                break@Inner
            }
            index++
        }
        println(index)
    }
}