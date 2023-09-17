package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.sharpbang.marketplaceback.baggins.model.request.NewUserRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateUserRequest
import ru.sharpbang.marketplaceback.baggins.model.response.CustomerInfoResponse
import ru.sharpbang.marketplaceback.baggins.model.response.SellerInfoResponse
import ru.sharpbang.marketplaceback.baggins.model.response.UserInfoResponse
import ru.sharpbang.marketplaceback.baggins.port.UserPort
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.GET_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.POST_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.PUT_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.executeWithLogging

@RestController
@RequestMapping("/users")
class UserController(
    private val userPort: UserPort
) {

    @GetMapping
    fun getUserInfo(@RequestParam userId: Long): UserInfoResponse =
        executeWithLogging(
            logger = logger,
            requestBody = userId,
            httpMethod = GET_METHOD,
            logPoint = SERVICE_LOG_POINT
        ) { userPort.getUserInfo(userId) }

    @PostMapping
    fun registerNewUser(@RequestBody newUserRequest: NewUserRequest) =
        executeWithLogging(
            logger = logger,
            requestBody = newUserRequest,
            httpMethod = POST_METHOD,
            logPoint = SERVICE_LOG_POINT
        ) { userPort.registerNewUser(newUserRequest) }

    @PutMapping("/update")
    fun updateUserInfo(@RequestBody updateUserRequest: UpdateUserRequest) =
        executeWithLogging(
            logger = logger,
            requestBody = updateUserRequest,
            httpMethod = PUT_METHOD,
            logPoint = SERVICE_LOG_POINT
        ) { userPort.updateUserInfo(updateUserRequest) }

    @GetMapping("/customers")
    fun getCustomerInfo(@RequestParam userId: Long): CustomerInfoResponse =
        executeWithLogging(
            logger = logger,
            requestBody = userId,
            httpMethod = GET_METHOD,
            logPoint = CUSTOMER_LOG_POINT
        ) { userPort.getCustomerInfo(userId) }

    @GetMapping("/sellers")
    fun getSellerInfo(@RequestParam userId: Long): SellerInfoResponse =
        executeWithLogging(
            logger = logger,
            requestBody = userId,
            httpMethod = GET_METHOD,
            logPoint = SELLER_LOG_POINT
        ) { userPort.getSellerInfo(userId) }


    companion object {
        private const val SERVICE_LOG_POINT = "USER"
        private const val CUSTOMER_LOG_POINT = "$SERVICE_LOG_POINT.CUSTOMER"
        private const val SELLER_LOG_POINT = "$SERVICE_LOG_POINT.SELLER"

        private val logger = KotlinLogging.logger {}
    }
}
