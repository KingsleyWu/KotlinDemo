package com.qooapp.kotlin.example.part3

val name: String by lazy { "d" }

interface Writer{
    fun write()
}

interface Driver{
    fun drive()
}

class Boss(val writer: Writer, val driver: Driver): Writer, Driver {
    override fun write() {
        writer.write()
    }

    override fun drive() {
        driver.drive()
    }
}

class Boss2(val writer: Writer, val driver: Driver): Writer by writer, Driver by driver

// 向后兼容重命名属性
class Delegate{
    var new: String = "new"
    @Deprecated("Use 'new' instead", ReplaceWith("new"))
    var old: String by this::new
}

fun main() {
    println(name)

    val boss = Boss(object : Writer{
        override fun write() {
            println("Writer write")
        }
    }, object : Driver{
        override fun drive() {
            println("Driver drive")
        }
    })
    boss.drive()
    boss.write()

    val boss2 = Boss2(object : Writer{
        override fun write() {
            println("Writer2 write")
        }
    }, object : Driver{
        override fun drive() {
            println("Driver2 drive")
        }
    })
    boss2.drive()
    boss2.write()

    val delegate = Delegate()
    delegate.old = "new"
    delegate.new
}
