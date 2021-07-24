package com.qooapp.kotlin.spring.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import java.io.Serializable
import java.util.*

@ApiModel("测试记录的简要信息")
open class RecordDto(
    /** 自增ID一律使用Long */
    @ApiModelProperty("记录ID")
    var id: Long = 0,
    @ApiModelProperty("记录名称")
    var recordName: String? = null,
    @ApiModelProperty("开始时间")
    var recordStartAt: Date? = null,
    @ApiModelProperty("结束时间")
    var recordEndAt: Date? = null,
    @ApiModelProperty("记录状态 0:未开始, 1:运行中, 2:成功, 3:失败")
    var status: Int = 0,
    @ApiModelProperty("结果的存放目录,相对于服务器cases目录")
    var resultPath: String? = null,
    @ApiModelProperty("总测试数,结束后才会有")
    var totalCases: Int = 0,
    @ApiModelProperty("成功测试数,结束后才会有")
    var successCases: Int = 0,
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}
