package com.qooapp.kotlin.spring.concurrent

import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Service
import java.util.concurrent.Future


@Service
class AsyncService {
    //InterruptedException 异常应该被处理并正确退出进程
    @Async
    @Throws(InterruptedException::class)
    fun asyncMethod(num1: Int, num2: Int): Future<Any> {
        val sum = num1 + num2
        println("执行了异步方法")
        Thread.sleep(5000)
        return AsyncResult.forValue(sum)
    }
}
