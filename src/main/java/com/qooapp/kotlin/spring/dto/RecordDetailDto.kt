package com.qooapp.kotlin.spring.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable

@ApiModel("测试记录的完整信息")
class RecordDetailDto : RecordDto() {
    @ApiModelProperty("详细测试数据")
    var rows: List<RecordRow>? = null

    @ApiModelProperty("日志下载url")
    var logDownloadUrl: String? = null

    @ApiModel("测试用例信息")
    class RecordRow : Serializable {
        @ApiModelProperty("耗时")
        var time: Int = 0

        @ApiModelProperty("测试用例名")
        var name: String? = null

        companion object {
            private const val serialVersionUID = 1L
        }
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
