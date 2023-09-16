package ru.sharpbang.marketplaceback.parser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParserApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ParserApplication>(*args)
}
