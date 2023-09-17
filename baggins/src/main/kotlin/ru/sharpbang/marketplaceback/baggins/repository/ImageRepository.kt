package ru.sharpbang.marketplaceback.baggins.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.ImageEntity

@Suppress("EmptyClassBlock")
interface ImageRepository : JpaRepository<ImageEntity, Long> {
}
