package ru.sharpbang.marketplaceback.baggins.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.SellerEntity

interface SellerRepository : JpaRepository<SellerEntity, Long> {
}