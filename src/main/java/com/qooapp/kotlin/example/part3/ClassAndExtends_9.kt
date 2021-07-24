package com.qooapp.kotlin.example.part3

//  类与继承
class Class1()

class Class2(name: String)

class Class3 constructor(arg1: String, arg2: String) {
    constructor(arg1: String): this(arg1, "")
}

// 等同于上面的构造函数重写
class Class4 @JvmOverloads constructor(arg1: String, arg2: String = "")

// class ComView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr)

// 继承时属性的重写
open class OpenClass(open var arg: String, open val arg2: String)

class A(override var arg: String = "") : OpenClass(arg, "")

// 会破坏父类的包装访问性
class B(override var arg: String = "", override var arg2: String = "") : OpenClass(arg, arg2)
