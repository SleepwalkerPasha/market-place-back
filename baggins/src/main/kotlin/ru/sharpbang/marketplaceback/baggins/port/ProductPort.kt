package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.response.ProductResponse

interface ProductPort {

    fun getProductById(id: Long): ProductResponse
}
