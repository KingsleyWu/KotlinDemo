package com.qooapp.kotlin.example.part3

// 自动生成
//  equals() / hashCode()
//  toString()
//  copy()
//  get() / set()
//  componentN() 函数按声明顺序对应于所有属性;
data class DataBean(var data: String, var arg: Any?, var arg2: String? = null)

fun main() {
    val dataBean = DataBean("data", "arg")
    print(dataBean)

    println(dataBean.data)
    println(dataBean.arg)
    println(dataBean.arg2)

    val (data, arg, arg2) = dataBean
    println(data)
    println(arg)
    println(arg2)

    println(dataBean.component1())
    println(dataBean.component2())
    println(dataBean.component3())
}