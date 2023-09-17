package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.model.response.ProductResponse
import ru.sharpbang.marketplaceback.baggins.port.ProductPort
import ru.sharpbang.marketplaceback.baggins.repository.ProductRepository
import ru.sharpbang.marketplaceback.baggins.support.mapper.ProductMapper
import ru.sharpbang.marketplaceback.baggins.support.utils.NotFoundException

@Service
class ProductUseCase(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) : ProductPort {
    override fun getProductById(id: Long): ProductResponse =
        productRepository.findById(id).orElseThrow { throw NotFoundException("product with id $id not found") }
            .run { productMapper.toModel(this) }
}
