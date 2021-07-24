package com.qooapp.kotlin.example

import com.qooapp.kotlin.example.bean.JavaBean
import com.qooapp.kotlin.example.bean.KotlinBean
import com.qooapp.kotlin.example.bean.DataKotlinBean
import com.qooapp.kotlin.example.utils.JavaUtils
import com.qooapp.kotlin.example.utils.kotlinTest
import com.qooapp.kotlin.example.utils.kotlinTest2
import com.qooapp.kotlin.example.part3.Companion
import com.qooapp.kotlin.example.part3.Companion.Companion.getCompanion
import com.qooapp.kotlin.example.part3.getName
import com.qooapp.kotlin.example.part3.toString

fun main() {
    val companion = Companion.getCompanion()
    println(companion)
    val name = Companion.getCompanion().getName()
    val name2 = getCompanion().getName()
    val name3 = companion.getName()
    println(name)
    println(name2)
    println(name3)
    val string = null.toString()
    println(string)

    // java
    JavaUtils.test()
    // 如果生成的有多個相同的 Java 文件（包名，類名都相同），可以使用
    // @JvmName + @JvmMultifileClass 註解進行合併成一個 Java 類，當然裡面方法有衝突是不行的
    kotlinTest()
    kotlinTest2()

    val javaBean = JavaBean()
    javaBean.arg = 1
    javaBean.arg2 =2
    javaBean.arg3 = "dddd"
    println(javaBean)

    val kotlinBean = KotlinBean()
    kotlinBean.arg = 1
    // Cannot access 'arg2': it is private in 'KotlinBean'
    // kotlinBean.arg2 =2
    kotlinBean.setArg2(2)
    kotlinBean.arg3 = "dddd"
    println(kotlinBean)

    val dataKotlinBean = DataKotlinBean()
    dataKotlinBean.arg = 1
    dataKotlinBean.arg2 =2
    dataKotlinBean.arg3 = "dddd"
    println(dataKotlinBean)
}