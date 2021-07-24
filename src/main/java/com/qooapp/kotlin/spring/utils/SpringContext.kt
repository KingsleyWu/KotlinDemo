package com.qooapp.kotlin.spring.utils

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component


@Component
class SpringContext : ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
        SpringContextUtils.setSpringContext(this)
    }

    fun getApplicationContext() = applicationContext

    fun getBean(name: String): Any? {
        return applicationContext.getBean(name)
    }

    fun <T> getBean(clazz: Class<T>): T {
        return applicationContext.getBean(clazz)
    }

    fun <T> getBean(name: String, clazz: Class<T>): T {
        return applicationContext.getBean(name, clazz)
    }

    /**
     * 获取当前环境
     */
    fun getActiveProfile(): String {
       return applicationContext.environment.activeProfiles.run {
           if (isNullOrEmpty()) "" else get(0)
       }
    }

    fun isProd() = "Prod" == getActiveProfile()
}