package ru.sharpbang.marketplaceback.baggins.model.request

data class NewUserRequest(
    val firstName: String,
    val surname: String,
    val email: String,
    val phone: String
)
