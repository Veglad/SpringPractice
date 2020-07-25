package com.veglad.springblog

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SpringblogApplication

fun main(args: Array<String>) {
    runApplication<SpringblogApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
