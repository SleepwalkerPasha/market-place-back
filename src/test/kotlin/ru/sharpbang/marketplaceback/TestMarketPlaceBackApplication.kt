package ru.sharpbang.marketplaceback

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestMarketPlaceBackApplication

fun main(args: Array<String>) {
    fromApplication<MarketPlaceBackApplication>().with(TestMarketPlaceBackApplication::class).run(*args)
}
