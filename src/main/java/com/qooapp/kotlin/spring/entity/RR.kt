package com.qooapp.kotlin.spring.entity

import com.qooapp.kotlin.spring.utils.SpringContextUtils
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.io.Serializable

@ApiModel("通用返回格式")
data class RR<T>(
    @ApiModelProperty("业务状态码,200表示OK")
    var code: Int = 200,
    @ApiModelProperty("错误信息")
    var message: String = "",
    var data: T
) : Serializable {

    companion object {
        private const val serialVersionUID = 1L

        /**
         * 处理正常返回
         */
        @JvmStatic
        fun <T> ok(data: T): RR<T> {
            return RR(200, "", data)
        }

        /**
         * 处理错误返回
         */
        @JvmStatic
        fun error(code: Int, message: String = "", rowData: Any? = null): RR<Any?> {
            var data = rowData
            if (rowData is Throwable) {
                data = when {
                    //生产环境不返回错误堆栈
                    SpringContextUtils.isProd() -> null
                    //如果是测试环境,则返回详细堆栈
                    else -> {
                        val outputStream = ByteArrayOutputStream()
                        rowData.printStackTrace(PrintStream(outputStream))
                        outputStream.toString()
                    }
                }
            }
            println("未知异常！原因是:$data")
            return RR(code, message, data)
        }
    }
}

