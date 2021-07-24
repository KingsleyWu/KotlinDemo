package com.qooapp.kotlin.spring.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import java.io.Serializable

@ApiModel("修改或新增项目的请求结构")
data class ProjectUpdateDto(
    @ApiModelProperty("项目显示名称")
    var name: String? = null,
    @ApiModelProperty("项目唯一标识")
    var projectCode: String? = null,
    @ApiModelProperty("服務器地址")
    var host: String? = null,
    @ApiModelProperty("项目配置的存放目录,相对于服务器cases目录")
    var dirName: String? = null,
    @ApiModelProperty("附帶的參數")
    var vars: String? = null,
) : Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }
}

