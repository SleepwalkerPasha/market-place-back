package ru.sharpbang.marketplaceback.baggins

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BagginsApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {

    runApplication<BagginsApplication>(*args)
}
