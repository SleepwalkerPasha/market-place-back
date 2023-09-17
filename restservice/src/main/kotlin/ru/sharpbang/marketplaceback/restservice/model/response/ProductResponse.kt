package ru.sharpbang.marketplaceback.restservice.model.response

import ru.sharpbang.marketplaceback.restservice.model.request.ImageRequest
import java.math.BigDecimal

data class ProductResponse (
    val title:String,
    val description:String?=null,
    val price: BigDecimal,
    var pictures: Set<ImageRequest>?=null
)
