package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import mu.KotlinLogging
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.sharpbang.marketplaceback.baggins.model.request.NewImageRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateImageRequest
import ru.sharpbang.marketplaceback.baggins.port.ImagePort
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.DELETE_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.GET_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.POST_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.PUT_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.executeWithLogging

@RestController
@RequestMapping("/images")
class ImageController(
    private val imagePort: ImagePort
) {
    @GetMapping("/{imageId}")
    fun getImageById(@PathVariable imageId: Long) = executeWithLogging(
        logger = logger, requestBody = imageId, logPoint = SERVICE_NAME, httpMethod = GET_METHOD
    ) {
        imagePort.getImageById(imageId)
    }

    @PostMapping
    fun addNewImage(@RequestBody imageRequest: NewImageRequest, @RequestParam productId: Long) = executeWithLogging(
        logger = logger, requestBody = imageRequest, logPoint = SERVICE_NAME, httpMethod = POST_METHOD
    ) {
        imagePort.addImage(imageRequest, productId)
    }

    @PutMapping("/update")
    fun updateImageInfo(@RequestBody updateImageRequest: UpdateImageRequest, @RequestParam productId: Long) =
        executeWithLogging(
            logger = logger, requestBody = updateImageRequest, logPoint = SERVICE_NAME, httpMethod = PUT_METHOD
        ) {
            imagePort.updateImage(updateImageRequest, productId)
        }

    @DeleteMapping("/{imageId}/delete")
    fun deleteImage(@PathVariable imageId: Long) = executeWithLogging(
        logger = logger, requestBody = imageId, logPoint = SERVICE_NAME, httpMethod = DELETE_METHOD
    ) {
        imagePort.deleteImage(imageId)
    }

    companion object {
        private const val SERVICE_NAME = "IMAGE"

        private val logger = KotlinLogging.logger {}
    }
}
