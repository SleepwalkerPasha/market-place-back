package ru.sharpbang.marketplaceback.baggins

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BagginsApplication

fun main(args: Array<String>) {
    runApplication<BagginsApplication>(*args)
}
