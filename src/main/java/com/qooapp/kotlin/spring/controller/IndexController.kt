package com.qooapp.kotlin.spring.controller

import com.qooapp.kotlin.spring.dto.ProjectDto
import com.qooapp.kotlin.spring.dto.ProjectUpdateDto
import com.qooapp.kotlin.spring.dto.RecordDetailDto
import com.qooapp.kotlin.spring.dto.RecordDto
import com.qooapp.kotlin.spring.entity.RR
import com.qooapp.kotlin.spring.service.AutoTestService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
//本类所有路径会跟在这个地址后面
@RequestMapping("/api/auto-test")
@Api(tags = ["自动化测试"])
class IndexController {

    @Autowired
    lateinit var autoTestService: AutoTestService

    @ApiOperation("新建/修改一个项目")
    @PostMapping("/project")
    fun updateProject(@RequestBody updateDto: ProjectUpdateDto?): RR<ProjectDto>? {
        //新建/修改一个项目并返回项目的最新信息
        return RR.ok(autoTestService.projectToDto(autoTestService.saveOrUpdate(updateDto)))
    }

    @ApiOperation("查询所有项目")
    @GetMapping("/projects")
    fun projects(): RR<List<ProjectDto>>? {
        return RR.ok(autoTestService.projectToDtos(autoTestService.selectAllProject()))
    }

    @ApiOperation(value = "执行项目得到一个新的记录", notes = "异步方法,立即返回")
    @PostMapping("/project/{projectCode}/run")
    fun runProject(projectCode: String?): RR<Int>? {
        //TODO 异步运行一个项目
        return null
    }

    @ApiOperation(value = "查询指定项目的最后n条记录")
    @ApiImplicitParams(
        ApiImplicitParam(name = "projectCode", value = "项目唯一标识", required = true, paramType = "path"),
        ApiImplicitParam(name = "count", value = "需要的记录数", required = true, paramType = "query")
    )
    @GetMapping("/project/{projectCode}/records")
    fun records(
        @PathVariable(name = "projectCode") projectCode: String?,
        @RequestParam(defaultValue = "50") count: Int?
    ): RR<List<RecordDto>>? {
        //TODO 拉取一个项目的最近的count条记录
        return null
    }

    @ApiOperation(value = "查询指定记录详情")
    @GetMapping("/project/{projectCode}/record/{recordId}")
    fun recordDetail(
        @PathVariable(name = "projectCode") projectCode: String?,
        @PathVariable(name = "recordId") recordId: Int?
    ): RR<RecordDetailDto>? {
        //TODO 查询指定id record 并填充详情
        return null
    }
}
