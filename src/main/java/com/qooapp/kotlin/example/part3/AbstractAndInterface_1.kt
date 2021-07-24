package com.qooapp.kotlin.example.part3

// 抽象类
abstract class AbstractClass {
    abstract fun abstractMethod()
    fun finalMethod() {}
    open fun defaultMethod() {}
}

class Class : AbstractClass() {
    override fun abstractMethod() {}
    override fun defaultMethod() {
        super.defaultMethod()
    }
}

// 接口I
interface IInterface {
    fun method()
    fun defaultMethod() {}
}

class InterfaceClass : IInterface {
    override fun method() {}
    override fun defaultMethod() {}
}
