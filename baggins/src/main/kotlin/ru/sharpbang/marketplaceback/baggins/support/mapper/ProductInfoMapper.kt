package ru.sharpbang.marketplaceback.baggins.support.mapper

import org.mapstruct.Mapper
import ru.sharpbang.marketplaceback.baggins.model.response.ProductInfoResponse
import ru.sharpbang.marketplaceback.baggins.repository.entities.ProductInfoEntity

@Mapper
interface ProductInfoMapper {

    fun toEntity(productInfoResponse: ProductInfoResponse): ProductInfoEntity

    fun toModel(productInfoEntity: ProductInfoEntity): ProductInfoResponse
}
