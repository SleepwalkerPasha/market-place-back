package ru.sharpbang.marketplaceback.restservice.model.response

import java.math.BigDecimal

data class ProductResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val price: BigDecimal,
    val picturesIds: Set<Long>?
)