package ru.sharpbang.marketplaceback.baggins.support.utils

import mu.KLogger

internal inline fun <I, reified R> executeWithLogging(
    logger: KLogger,
    requestBody: I,
    logPoint: String,
    httpMethod: String,
    crossinline block: (I) -> R
): R {
    logger.info { "$httpMethod $logPoint.request : $requestBody" }
    runCatching {
        return block(requestBody).also {
            logger.info { "$httpMethod $logPoint.response : $it" }
        }
    }.getOrElse {
        logger.error { "$httpMethod $logPoint.error : ${it.toErrorResponse()}"  }
        throw it
    }
}
