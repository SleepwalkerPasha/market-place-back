package ru.sharpbang.marketplaceback.baggins.support.mapper

import org.mapstruct.Mapper
import ru.sharpbang.marketplaceback.baggins.model.response.ProductResponse
import ru.sharpbang.marketplaceback.baggins.repository.entities.ProductEntity

@Mapper
interface ProductMapper {

    fun toEntity(productResponse: ProductResponse): ProductEntity

    fun toModel(productEntity: ProductEntity): ProductResponse
}
