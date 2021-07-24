package com.qooapp.kotlin.spring.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable
import java.util.*

@TableName("project_infos")
data class ProjectEntity(
    @TableId(type = IdType.AUTO)
    var id: Long? = null,
    var name: String? = null,
    @TableField("project_key")
    var projectCode: String? = null,
    var host: String? = null,
    var dirName: String? = null,
    var vars: String? = null,
    var createdAt: Date? = null,
    var updatedAt: Date? = null,
    var deletedAt: Date? = null,
) : Serializable