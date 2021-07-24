package com.qooapp.kotlin.spring.config

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.Contact
import springfox.documentation.service.SecurityScheme
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@EnableKnife4j
// @Profile({"local","devel"}) //这里限制启用的环境
class SwaggerConfiguration {

    @Bean(value = ["defaultApi3"])
    fun defaultApi3(environment: Environment?): Docket? {
        return Docket(DocumentationType.OAS_30)
            .apiInfo(
                ApiInfoBuilder()
                    .title("项目名称")
                    .description("项目功能描述")
                    .termsOfServiceUrl("项目协议地址")
                    .contact(Contact("联系人", "网址", "邮箱"))
                    .version("软件版本")
                    .build()
            ) //分组名称
            .groupName("web端") //此处用于一个项目对接有多个客户的时候,例如:app端
            .select() //这里指定Controller扫描包路径
            .apis(RequestHandlerSelectors.basePackage("com.qooapp"))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(unifiedAuth())
    }

    //这里指定认证方式.一般指定token存放位置
    private fun unifiedAuth(): List<SecurityScheme> {
        return listOf(ApiKey("Authorization", "Authorization", "header"))
    }

}