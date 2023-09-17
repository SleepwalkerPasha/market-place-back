package ru.sharpbang.marketplaceback.baggins.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.sharpbang.marketplaceback.baggins.repository.entities.ImageEntity

interface ImageRepository : JpaRepository<ImageEntity, Long> {

    @Query("select i from ImageEntity i where i.productEntity.id = ?1")
    fun findAllByProductEntityId(productId: Long): Set<ImageEntity>
}
