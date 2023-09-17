package ru.sharpbang.marketplaceback.baggins.model.response

data class UserInfoResponse(
    val id: Long,
    val firstName: String,
    val surname: String,
    val email: String,
    val phone: String
)