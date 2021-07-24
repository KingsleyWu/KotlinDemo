package com.qooapp.kotlin.example.bean

class KotlinBean{
    var arg = 0
    private var arg2: Int? = null
    var arg3: String? = null

    fun getArg2(): Int? {
        return arg2
    }

    fun setArg2(arg2: Int?) {
        this.arg2 = arg2
    }

    override fun toString(): String {
        return "KotlinBean(arg=$arg, arg2=$arg2, arg3=$arg3)"
    }

}