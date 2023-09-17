package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.model.response.ProductInfoResponse
import ru.sharpbang.marketplaceback.baggins.port.ProductInfoPort
import ru.sharpbang.marketplaceback.baggins.repository.ProductInfoRepository
import ru.sharpbang.marketplaceback.baggins.support.mapper.ProductInfoMapper

@Service
class ProductInfoUseCase(
    private val productInfoRepository: ProductInfoRepository,
    private val productInfoMapper: ProductInfoMapper
) : ProductInfoPort {

    override fun getProductCharacteristics(productId: Long): List<ProductInfoResponse> =
        productInfoRepository.findAllByProductId(productId).map { productInfoMapper.toModel(it) }
}
