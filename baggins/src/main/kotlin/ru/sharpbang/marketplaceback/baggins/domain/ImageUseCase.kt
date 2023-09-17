package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.model.request.NewImageRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateImageRequest
import ru.sharpbang.marketplaceback.baggins.model.response.ImageResponse
import ru.sharpbang.marketplaceback.baggins.port.ImagePort
import ru.sharpbang.marketplaceback.baggins.repository.ImageRepository
import ru.sharpbang.marketplaceback.baggins.repository.ProductRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.ImageEntity
import ru.sharpbang.marketplaceback.baggins.repository.entities.ProductEntity
import ru.sharpbang.marketplaceback.baggins.support.utils.NotFoundException

@Service
class ImageUseCase(
    private val imageRepository: ImageRepository,
    private val productRepository: ProductRepository
) : ImagePort {
    override fun getImageById(id: Long): ImageResponse =
        imageRepository.findById(id).orElseThrow { throw NotFoundException("image with id $id not found") }
            .run { this.toResponse() }

    override fun addImage(newImageRequest: NewImageRequest, productId: Long): ImageResponse =
        imageRepository.save(newImageRequest.toEntity(
            productRepository.findById(productId)
                .orElseThrow { throw NotFoundException("product with id $productId not found") }
        )).toResponse()

    override fun updateImage(updateImageRequest: UpdateImageRequest, productId: Long): ImageResponse =
        imageRepository.save(
            updateImageRequest.toEntity(oldImageResponse = getImageById(updateImageRequest.id),
                productEntity = productRepository.findById(productId)
                    .orElseThrow { throw NotFoundException("product with id $productId not found") })
        ).toResponse()

    override fun deleteImage(imageId: Long) = imageRepository.deleteById(imageId)

    override fun getImagesByProductId(productId: Long): List<ImageResponse> =
        imageRepository.findAllByProductEntity_Id(productId).map { it.toResponse() }

}

private fun UpdateImageRequest.toEntity(oldImageResponse: ImageResponse, productEntity: ProductEntity) = ImageEntity(
    title = this.title ?: oldImageResponse.title,
    content = this.content ?: oldImageResponse.content,
    productEntity = productEntity
)

private fun NewImageRequest.toEntity(productEntity: ProductEntity) = ImageEntity(
    title = this.title,
    content = this.content,
    productEntity = productEntity
)

fun ImageEntity.toResponse() = ImageResponse(
    id = this.id!!,
    title = this.title!!,
    content = this.content!!,
    productId = this.productEntity!!.id!!
)
