package ru.sharpbang.marketplaceback.baggins.support.mapper

import org.mapstruct.Mapper
import ru.sharpbang.marketplaceback.baggins.model.response.ImageResponse
import ru.sharpbang.marketplaceback.baggins.repository.entities.ImageEntity

@Mapper
interface ImageMapper {

    fun toEntity(imageResponse: ImageResponse): ImageEntity

    fun toModel(imageEntity: ImageEntity): ImageResponse
}
