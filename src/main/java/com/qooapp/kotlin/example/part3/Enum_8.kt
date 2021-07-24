package com.qooapp.kotlin.example.part3

// 枚举
enum class Enum {
    A,B,C,D
}

// 带参
enum class Enum2(val arg: String) {
    A("a"),B("b"),C("c"),D("d")
}

fun main() {
    when(getEnum()){
        Enum.A -> {}
        Enum.B -> {}
        Enum.C -> {}
        Enum.D -> {}
    }
    when(getEnum2()){
        Enum2.A -> {}
        Enum2.B -> {}
        Enum2.C -> {}
        Enum2.D -> {}
    }
}

fun getEnum() = Enum.A

fun getEnum2() = Enum2.A