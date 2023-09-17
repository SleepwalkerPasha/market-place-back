package ru.sharpbang.marketplaceback.baggins.port

import ru.sharpbang.marketplaceback.baggins.model.request.NewProductRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateProductRequest
import ru.sharpbang.marketplaceback.baggins.model.response.ProductResponse

interface ProductPort {

    fun getProductById(id: Long): ProductResponse
    fun addNewProduct(newProductRequest: NewProductRequest): ProductResponse
    fun updateProductInfo(updateProductRequest: UpdateProductRequest): ProductResponse
    fun deleteProduct(productId: Long)
}
