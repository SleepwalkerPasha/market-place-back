package ru.sharpbang.marketplaceback.restservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestserviceApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<RestserviceApplication>(*args)
}
