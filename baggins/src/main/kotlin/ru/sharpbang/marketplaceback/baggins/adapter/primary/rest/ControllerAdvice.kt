package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.sharpbang.marketplaceback.baggins.support.utils.ErrorResponse
import ru.sharpbang.marketplaceback.baggins.support.utils.toErrorResponse

@RestControllerAdvice
class ControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable::class)
    fun handleRuntime(e: Throwable): ErrorResponse = e.toErrorResponse(code = HttpStatus.INTERNAL_SERVER_ERROR.value())
}
