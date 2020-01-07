package com.sbaier.aoptest.callCount

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CallCountApplication

fun main(args: Array<String>) {
	runApplication<CallCountApplication>(*args)
}
