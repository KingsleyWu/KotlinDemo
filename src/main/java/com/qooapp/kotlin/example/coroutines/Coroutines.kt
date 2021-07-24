package com.qooapp.kotlin.example.coroutines

import com.qooapp.kotlin.example.retrofit.HttpHelper
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

// coroutineScope 協程範圍
// 用於解決異步問題
// 應用層完成調度
// 非搶佔式
// 掛起，等事件來了後再
// 使異步代碼像同步代碼一樣直觀
// 簡化異步代碼異常處理
// 輕量級的並發方案 -> 不像線程會單獨的佔用資源，它只是一塊內存，只是一個對象，它裡面只存了剛剛掛起的那地方的位置，用於（如圖片下載完了）之後，告訴程序繼續往下執行的位置

fun main() {
//    test1()
//    runBlocking {
//        test2()
//    }
    test3()
}

fun test1() {
    thread { // launch a new thread and continue
        Thread.sleep(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed

}

suspend fun test2() = coroutineScope {
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

fun test3() {
    try {
        val message = runBlocking {
            HttpHelper.apiService.getProjects()
        }
        println("test3 : $message")
    } catch (e: Exception){
        println("test3 : $e")
    }

}

