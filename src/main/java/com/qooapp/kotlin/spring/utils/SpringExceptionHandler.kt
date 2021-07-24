package com.qooapp.kotlin.spring.utils

import com.qooapp.kotlin.spring.entity.RR
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ControllerAdvice
class SpringExceptionHandler {

    @ExceptionHandler(value = [Exception::class])
    @ResponseBody
    fun exceptionHandler(e: Exception): RR<Any?>? {
        println("未知异常！原因是:$e")
        return RR.error( 500, rowData = e)
    }
}