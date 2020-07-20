package com.veglad.springblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringblogApplication

fun main(args: Array<String>) {
	runApplication<SpringblogApplication>(*args)
}
