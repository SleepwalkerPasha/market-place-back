package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.sharpbang.marketplaceback.baggins.model.response.UserInfoResponse
import ru.sharpbang.marketplaceback.baggins.port.UserPort

@RestController
@RequestMapping("/users")
class UserController(
    private val userPort: UserPort
) {

    @GetMapping
    fun getUserInfo(@RequestParam userId: Long): UserInfoResponse = userPort.getUserById(userId)


    companion object{
        private val logger = KotlinLogging.logger {}
    }
}
