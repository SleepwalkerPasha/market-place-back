package ru.sharpbang.marketplaceback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BotApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<BotApplication>(*args)
}
