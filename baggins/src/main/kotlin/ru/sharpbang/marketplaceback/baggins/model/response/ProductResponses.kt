package ru.sharpbang.marketplaceback.baggins.model.response

import java.math.BigDecimal

data class ProductResponse(
    val id: Long,
    val title: String,
    val description: String,
    val price: BigDecimal,
    val pictures: List<ImageResponse>
)

data class ProductInfoResponse(
    val productId: Long,
    val infoFieldName: String,
    val infoFieldValue: String,
)
