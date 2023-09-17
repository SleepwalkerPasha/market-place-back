package ru.sharpbang.marketplaceback.baggins.support.utils

class NotFoundException(message: String?) : RuntimeException(message)

fun Throwable.toErrorResponse(code: Int = 500) = ErrorResponse(cause = this, message = this.message, code = code)

data class ErrorResponse(
    val cause: Throwable,
    val message: String?,
    val code: Int
)
