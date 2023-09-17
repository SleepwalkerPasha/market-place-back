package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.request.NewImageRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateImageRequest
import ru.sharpbang.marketplaceback.baggins.model.response.ImageResponse

interface ImagePort {

    fun getImageById(id: Long): ImageResponse

    fun addImage(newImageRequest: NewImageRequest, productId: Long): ImageResponse

    fun updateImage(updateImageRequest: UpdateImageRequest, productId: Long): ImageResponse

    fun deleteImage(imageId: Long)

    fun getImagesByProductId(productId: Long): List<ImageResponse>
}
