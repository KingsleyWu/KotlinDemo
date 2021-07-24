package com.qooapp.kotlin.example.part3

// 嵌套类 和 内部类
class Outer {
    private var arg: String = "arg"

    // 嵌套类不具备外部引用
    // 实例化时，使用的是 Outer.Nested()
    class Nested {
        fun getArg() = "arg"
    }

    // 内部类具有外部类引用
    // 实例化时，使用的是 Outer().Inner()
    inner class Inner() {
        fun getArg() = arg
    }
}

// 匿名内部类
fun main() {
    val nested = Outer.Nested()
    nested.getArg()
    val inner = Outer().Inner()
    inner.getArg()

    val boss = Boss(object : Writer {
        override fun write() {
            // write
        }
    }, object : Driver {
        override fun drive() {
            // drive
        }
    })
}


