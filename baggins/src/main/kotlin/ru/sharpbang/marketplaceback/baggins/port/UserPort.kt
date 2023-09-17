package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.response.UserInfoResponse

interface UserPort {

    fun getUserById(id: Long): UserInfoResponse
}