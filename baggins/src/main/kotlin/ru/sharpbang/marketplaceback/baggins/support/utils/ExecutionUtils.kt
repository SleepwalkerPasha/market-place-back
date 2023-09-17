package ru.sharpbang.marketplaceback.baggins.support.utils

import mu.KLogger

internal inline fun <I, reified R> executeWithLogging(
    logger: KLogger,
    requestBody: I,
    crossinline block: (I) -> R,
    logPoint: String
): R {
    logger.info { "$logPoint.request : $requestBody" }
    runCatching {
        return block(requestBody).also {
            logger.info { "$logPoint.response : $it" }
        }
    }.getOrElse {
        logger.error { it.toErrorResponse() }
        throw it
    }
}
