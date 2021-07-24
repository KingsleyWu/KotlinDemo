package com.qooapp.kotlin.example.part1

/**
 * 基本類型
 */
class BasicType {
    val aBoolean: Boolean = true

    val anInt: Int = 8
    val anotherInt: Int = 0xFF
    val moreInt: Int = 0b00000011
    val maxInt: Int = Int.MAX_VALUE
    val minInt: Int = Int.MIN_VALUE

    val aLong: Long = 12368172397127391
    val another: Long = 123
    val maxLong: Long = Long.MAX_VALUE
    val minLong: Long = Long.MIN_VALUE

    val aFloat: Float = 2.0F
    val anotherFloat: Float = 1E3f
    val maxFloat: Float = Float.MAX_VALUE
    val minFloat: Float = -Float.MAX_VALUE

    val aDouble: Double = 3.0
    val anotherDouble: Double = 3.1415926
    val maxDouble: Double= Double.MAX_VALUE
    val minDouble: Double= -Double.MAX_VALUE

    val aShort: Short = 127
    val maxShort: Short = Short.MAX_VALUE
    val minShort: Short = Short.MIN_VALUE

    val maxByte: Byte = Byte.MAX_VALUE
    val minByte: Byte = Byte.MIN_VALUE

    val string = "string"
    var char = 'a'
}
