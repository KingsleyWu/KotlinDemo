package com.qooapp.kotlin

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.AsyncConfigurer


@SpringBootApplication
//添加这条到主类上
@MapperScan("com.qooapp.kotlin.**.mapper")
class KotlinDemoApplication : AsyncConfigurer {

    //如果想要分页特性.则添加 到主类中
    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        return MybatisPlusInterceptor().apply {
            addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
        }
    }

}

fun main(args: Array<String>) {
    runApplication<KotlinDemoApplication>(*args)
}
