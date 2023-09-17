package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.request.NewUserRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateUserRequest
import ru.sharpbang.marketplaceback.baggins.model.response.CustomerInfoResponse
import ru.sharpbang.marketplaceback.baggins.model.response.SellerInfoResponse
import ru.sharpbang.marketplaceback.baggins.model.response.UserInfoResponse

interface UserPort {

    fun getUserInfo(id: Long): UserInfoResponse

    fun getCustomerInfo(id: Long): CustomerInfoResponse

    fun getSellerInfo(id: Long): SellerInfoResponse

    fun registerNewUser(newUserRequest: NewUserRequest): UserInfoResponse

    fun updateUserInfo(updateUserRequest: UpdateUserRequest): UserInfoResponse
}
