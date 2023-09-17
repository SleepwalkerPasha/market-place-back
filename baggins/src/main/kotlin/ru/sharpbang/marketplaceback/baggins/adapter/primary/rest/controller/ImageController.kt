package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.sharpbang.marketplaceback.baggins.port.ImagePort
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.GET_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.executeWithLogging

@RestController
@RequestMapping("/images")
class ImageController(
    private val imagePort: ImagePort
) {


    @GetMapping
    fun getImageById(@RequestParam id: Long) =
        executeWithLogging(logger = logger, requestBody = id, logPoint = SERVICE_NAME, httpMethod = GET_METHOD) {
            imagePort.getImageById(id)
        }

    companion object {
        private const val SERVICE_NAME = "IMAGE"

        private val logger = KotlinLogging.logger {}
    }
}
