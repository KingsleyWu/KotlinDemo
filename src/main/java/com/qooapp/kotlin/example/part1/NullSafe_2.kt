package com.qooapp.kotlin.example.part1


private fun test1() {
    val string = getString()
    if (string != null) {
        println(string.length)
    }
    // Method invocation 'length' may produce 'NullPointerException'
    // 调用符
    // !! 强行调用符
    println(string!!.length)
}

private fun test2() {
    val string = getString() ?: return
    println(string.length)
}

private fun test3() {
    val string = getString()
    // 调用符
    // ?. 安全调用符
    println(string?.length ?: 0)
}

private fun getString(): String? {
    return null
}


fun main() {
    test1()
    //test2()
}