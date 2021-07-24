package com.qooapp.kotlin.spring.service.impl

import com.baomidou.mybatisplus.core.toolkit.StringUtils
import com.baomidou.mybatisplus.core.toolkit.Wrappers
import com.baomidou.mybatisplus.core.toolkit.support.SFunction
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.qooapp.kotlin.spring.dto.ProjectDto
import com.qooapp.kotlin.spring.dto.ProjectUpdateDto
import com.qooapp.kotlin.spring.entity.ProjectEntity
import com.qooapp.kotlin.spring.mapper.ProjectMapper
import com.qooapp.kotlin.spring.service.AutoTestService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class AutoTestServiceImpl: AutoTestService {

    @Autowired
    lateinit var projectMapper: ProjectMapper

    override fun projectToDtos(entitis: List<ProjectEntity?>?): List<ProjectDto> {
        val dtos = mutableListOf<ProjectDto>()
        entitis?.forEach {
            dtos.add(projectToDto(it))
        }
        return dtos
    }

    override fun projectToDto(entity: ProjectEntity?): ProjectDto {
        val dto = ProjectDto()
        entity?.let {
            BeanUtils.copyProperties(it, dto)
        }
        return dto
    }

    override fun selectAllProject(): List<ProjectEntity?>? {
        val queryWrapper = Wrappers.lambdaQuery(ProjectEntity::class.java)
        return projectMapper.selectList(queryWrapper)
    }

    override fun saveOrUpdate(updateDto: ProjectUpdateDto?): ProjectEntity? {
        if (updateDto == null) return null
        val entity = ProjectEntity()
        BeanUtils.copyProperties(updateDto, entity)
        entity.createdAt = Date()
        entity.updatedAt = Date()
        val ktQueryWrapper = KtQueryWrapper(ProjectEntity::class.java)
        val result = if (StringUtils.isBlank(entity.projectCode)) {
            entity.projectCode = UUID.randomUUID().toString()
            projectMapper.insert(entity)
        } else {
            projectMapper.update(entity,
                ktQueryWrapper
                    .eq(ProjectEntity::projectCode, entity.projectCode)
            )
        }
        println("result : $result")
        return projectMapper.selectOne(Wrappers.lambdaQuery(ProjectEntity::class.java)
            .eq(ProjectEntity::projectCode, entity.projectCode))
    }

}