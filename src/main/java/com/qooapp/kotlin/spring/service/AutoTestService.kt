package com.qooapp.kotlin.spring.service

import com.qooapp.kotlin.spring.dto.ProjectDto
import com.qooapp.kotlin.spring.dto.ProjectUpdateDto
import com.qooapp.kotlin.spring.entity.ProjectEntity


interface AutoTestService {
    //Controller 只有参数校验和返回封装逻辑.
    //Service 存放业务逻辑
    //除了这种 转换方法,其他方法都应该只返回entity对象.
    fun projectToDtos(entitis: List<ProjectEntity?>?): List<ProjectDto>
    fun projectToDto(entity: ProjectEntity?): ProjectDto
    fun saveOrUpdate(updateDto: ProjectUpdateDto?): ProjectEntity?
    fun selectAllProject(): List<ProjectEntity?>?
//    fun recordToDtos(entitis: List<RecordEntity?>?): List<RecordDto?>?
//    fun recordToDto(entity: RecordEntity?): RecordDto?
//    fun recordToDetailDto(entity: RecordEntity?): RecordDetailDto?
}
