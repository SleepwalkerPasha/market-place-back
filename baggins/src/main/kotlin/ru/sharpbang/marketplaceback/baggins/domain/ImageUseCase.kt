package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.model.response.ImageResponse
import ru.sharpbang.marketplaceback.baggins.port.ImagePort
import ru.sharpbang.marketplaceback.baggins.repository.ImageRepository
import ru.sharpbang.marketplaceback.baggins.support.mapper.ImageMapper
import ru.sharpbang.marketplaceback.baggins.support.utils.NotFoundException

@Service
class ImageUseCase(
    private val imageRepository: ImageRepository,
    private val imageMapper: ImageMapper
) : ImagePort {
    override fun getImageById(id: Long): ImageResponse =
        imageRepository.findById(id).orElseThrow { throw NotFoundException("image with id $id not found") }
            .run { imageMapper.toModel(this) }
}
