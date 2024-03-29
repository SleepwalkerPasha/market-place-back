package ru.sharpbang.marketplaceback.baggins.model.request

data class NewUserRequest(
    val firstName: String,
    val surname: String,
    val email: String,
    val phone: String
)

data class UpdateUserRequest(
    val id: Long,
    val firstName: String? = null,
    val surname: String?= null,
    val email: String? = null,
    val phone: String? = null,
)
