package com.qooapp.kotlin.example.part2

fun main() {
    // 默認參數
    argFun()
    argFun(5)
    // 如默认参数在前，则后面的都需要使用具体的参数名
    argFun2(arg2 = 5)
    // 如默认参数在最后面，不需要使用具体的参数名
    argFun3(5)

    // 可變參數
    varargFun("ddd", "sss", "asfdasdf")
    // arg = 1，是用来防止传参有歧义（即无法识别）
    varargFun("ddd", "sss", "asfdasdf", arg = 1)
    val array = arrayOf("ddd", "sss", "asfdasdf")
    // * 表示对array 进行展开，Spread Operator（展开运算符）只支持 Array
    varargFun(*array, arg = 1)
}

fun argFun(arg: Int = 0) {
    println("arg $arg")
}

fun argFun2(arg: Int = 0, arg2: Int) {
    println("arg $arg, arg2 $arg2")
}

fun argFun3(arg: Int, arg2: Int = 0) {
    println("arg $arg, arg2 $arg2")
}

fun varargFun(vararg args: String){
    args.forEach { println("arg $it") }
}
fun varargFun(vararg args: String, arg: Int){
    args.forEach { println("arg $arg, $it") }
}
