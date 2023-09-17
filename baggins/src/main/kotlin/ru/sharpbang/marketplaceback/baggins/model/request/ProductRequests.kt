package ru.sharpbang.marketplaceback.baggins.model.request

import java.math.BigDecimal

data class NewProductRequest(
    val title: String,
    val description: String,
    val price: BigDecimal,
    val picturesIds: Set<Long>
)

data class UpdateProductRequest(
    val id: Long,
    val title: String? = null,
    val description: String? = null,
    val price: BigDecimal? = null,
    val picturesIds: Set<Long>? = null
)
