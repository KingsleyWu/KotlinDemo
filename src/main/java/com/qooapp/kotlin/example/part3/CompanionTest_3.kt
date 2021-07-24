package com.qooapp.kotlin.example.part3

// 伴生对象
class Companion {
    // 伴生对象默认使用的名称是 Companion
    // 可以使用 自定义的名称，使用
    // companion object CompanionName
    companion object {
        fun getCompanion() = Companion()
    }
}

// 伴生对象
class Companion2 {
    // 可以实现接口
    companion object : IInterface {
        // 静态变量
        @JvmField
        val CONST = 0
        const val CONST1 = 0
        fun getCompanion() = Companion()
        override fun method() {}
    }
}

