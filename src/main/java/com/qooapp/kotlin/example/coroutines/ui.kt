package com.qooapp.kotlin.example.coroutines

import kotlinx.coroutines.delay
import retrofit2.http.Url
import kotlin.coroutines.*

fun main() {
    我要開始協程了 {
        我要開始切線程了 {
            val image = 我要開始加載圖片了("")
        }
    }
}

fun 我要開始協程了(block: suspend () -> Unit){
    block.startCoroutine(BaseContinuation())
}

suspend fun 我要開始切線程了(function: suspend() -> Unit){
    delay(5000L)
    function.invoke()
}

suspend fun 我要開始加載圖片了(url: String?) = suspendCoroutine<ByteArray> {
    if (url != null) {
        it.resumeWith(Result.success(ByteArray(1)))
    } else{
        it.resumeWith(Result.failure(Exception()))
    }
}

class BaseContinuation() : Continuation<Unit>{
    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {

    }

}