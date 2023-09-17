package ru.sharpbang.marketplaceback.baggins.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "products")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String? = null,

    @Lob
    @Column(nullable = false)
    var description: String? = null,

    @Column(nullable = false)
    var price: java.math.BigDecimal? = null,
)
