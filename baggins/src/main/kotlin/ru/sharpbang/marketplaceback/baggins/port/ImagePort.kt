package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.response.ImageResponse

interface ImagePort {

    fun getImageById(id: Long): ImageResponse
}
