package ru.sharpbang.marketplaceback.baggins.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.ProductDto

@Suppress("EmptyClassBlock")
interface ProductRepository: JpaRepository<ProductDto, Long> {
}
