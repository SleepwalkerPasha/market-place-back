package ru.sharpbang.marketplaceback.restservice.model.request

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.math.BigDecimal

data class ProductRequest(
    @field:NotBlank
    val title: String,
    val description: String?,
    @field:DecimalMin(value = "0.0", inclusive = false)
    val price: BigDecimal,
    var pictures: Set<ImageRequest>?=null
)