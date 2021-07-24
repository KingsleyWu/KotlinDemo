package com.qooapp.kotlin.example.part1

open class Parent

class Child : Parent() {
    fun getName() = "Child"
}

fun main() {
    var parent: Parent = Child()
    if (parent is Child) {
        parent.getName()
    }

    val string: String? = "xxxx"
    if (string != null) {
        println(string.length)
    }

    parent = Parent()
    var child = parent as Child // 报强转错误
    var child2 = parent as? Child // 安全

    var parent2: Parent? = null
    if (parent == null) {
        parent2 = Child()
    }
    parent2!!.hashCode()
    parent2.toString()
}