package com.qooapp.kotlin.example.part2

// + - * / % ^ ? ! ++ -- in !in  a[i]
fun main() {
    val plus1 = Plus(1, 2)
    val plus2 = Plus(3, 4)
    println(plus1 + plus2)
    println(plus1 + 5)
    println(plus1 + 1.1)
    println(plus1())

    val valueOf = "lalalalala"
    println(valueOf.valueOf("hahahah "))

    val tv = TV()
    val wall = Wall(tv)
    if (tv on wall) {
        println("tv倒贴在墙上了")
    }
}

// Tips：定义运算符方法时，只允许有一个参数，但对参数和返回值的类型无要求
class Plus(var arg1: Int, var arg2: Int) {

    operator fun plus(other: Plus): Plus {
        return Plus(arg1 + other.arg1, arg2 + other.arg2)
    }

    // 可以任意类型，但参数只能有一个
    operator fun plus(other: Int): Plus {
        return Plus(arg1 + other, arg2 + other)
    }

    // 返回值也可以是任意
    operator fun plus(other: Double): Int {
        return (arg1 + other + arg2).toInt()
    }

    operator fun invoke(): Plus {
        return Plus(arg1 + arg2, arg2 - arg1)
    }

    override fun toString(): String {
        return "arg1: $arg1, arg2: $arg2"
    }
}

// infix 函数 中缀表达式
// 必须是成员函数或扩展函数
// 必须只能接受一个参数，并且不能有默认值
infix fun String.valueOf(any: Any): String {
    return any.toString() + this
}

class TV {
    // infix 中缀表达式 表示允许你不使用 . 或 （）来调用方法
    infix fun on(wall: Wall) = wall.has(this)
}

class Wall(private var tv: TV? = null) {
    fun has(tv: TV): Boolean {
        return this.tv === tv
    }
}

