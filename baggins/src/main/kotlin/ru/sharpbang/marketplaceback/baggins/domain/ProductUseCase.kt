package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.model.request.NewProductRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateProductRequest
import ru.sharpbang.marketplaceback.baggins.model.response.ImageResponse
import ru.sharpbang.marketplaceback.baggins.model.response.ProductResponse
import ru.sharpbang.marketplaceback.baggins.port.ProductPort
import ru.sharpbang.marketplaceback.baggins.repository.ImageRepository
import ru.sharpbang.marketplaceback.baggins.repository.ProductRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.ProductEntity
import ru.sharpbang.marketplaceback.baggins.support.utils.NotFoundException

@Service
class ProductUseCase(
    private val productRepository: ProductRepository,
    private val imageRepository: ImageRepository
) : ProductPort {
    override fun getProductById(id: Long): ProductResponse =
        productRepository.findById(id).orElseThrow { throw NotFoundException("product with id $id not found") }.run {
            this.toModel(imageRepository.findAllByProductEntity_Id(this.id!!).map { it.toResponse() })
        }

    override fun addNewProduct(newProductRequest: NewProductRequest) =
        productRepository.save(newProductRequest.toEntity())
            .run { this.toModel(imageRepository.findAllByProductEntity_Id(this.id!!).map { it.toResponse() }) }

    override fun updateProductInfo(updateProductRequest: UpdateProductRequest) =
        productRepository.save(updateProductRequest.toEntity(getProductById(id = updateProductRequest.id)))
            .run { this.toModel(imageRepository.findAllByProductEntity_Id(this.id!!).map { it.toResponse() }) }

    override fun deleteProduct(productId: Long) = productRepository.deleteById(productId)
}

private fun ProductEntity.toModel(pictures: List<ImageResponse>): ProductResponse = ProductResponse(
    id = this.id!!,
    description = this.description!!,
    title = this.title!!,
    pictures = pictures,
    price = this.price!!
)

private fun UpdateProductRequest.toEntity(oldProductResponse: ProductResponse) = ProductEntity(
    id = this.id,
    description = this.description ?: oldProductResponse.description,
    title = this.title ?: oldProductResponse.title,
    price = this.price ?: oldProductResponse.price
)

private fun NewProductRequest.toEntity() = ProductEntity(
    description = this.description,
    title = this.title,
    price = this.price
)
