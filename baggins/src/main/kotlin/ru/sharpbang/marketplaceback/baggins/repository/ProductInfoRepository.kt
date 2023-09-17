package ru.sharpbang.marketplaceback.baggins.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.sharpbang.marketplaceback.baggins.model.response.ProductInfoResponse
import ru.sharpbang.marketplaceback.baggins.repository.entities.ProductInfoEntity

interface ProductInfoRepository: JpaRepository<ProductInfoEntity, Long> {

    @Query("select pi from ProductInfoEntity pi where pi.productId = ?1")
    fun findAllByProductId(productId: Long): List<ProductInfoResponse>
}
