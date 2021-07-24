package com.qooapp.kotlin.spring.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.qooapp.kotlin.spring.entity.ProjectEntity

//此接口已經具備基礎的CURD 能力, 如果想自己寫sql則在這裡寫.後面有說明
interface ProjectMapper: BaseMapper<ProjectEntity?>