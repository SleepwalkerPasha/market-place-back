package ru.sharpbang.marketplaceback.baggins.repository.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "sellers")
class SellerEntity(
    @Id var id: Long? = null,
    var salesAmount: BigDecimal? = null
)
