package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @Suppress("FunctionOnlyReturningConstant", "UnusedParameter")
    @GetMapping
    fun getUserInfo(@RequestParam userId: String): String {
        return "huesos"
    }
}
