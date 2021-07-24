@file:JvmName("KotlinUtils")
@file:JvmMultifileClass

package com.qooapp.kotlin.example.utils

import kotlin.random.Random

fun kotlinTest2(): Int {
    return Random(3).nextInt()
}