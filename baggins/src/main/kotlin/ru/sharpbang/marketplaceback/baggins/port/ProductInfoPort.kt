package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.response.ProductInfoResponse

interface ProductInfoPort {

    fun getProductCharacteristics(productId: Long): List<ProductInfoResponse>
}
