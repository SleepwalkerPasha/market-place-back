package ru.sharpbang.marketplaceback.baggins.repository.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "products_info")
@IdClass(ProductInfoEntityId::class)
class ProductInfoEntity(
    @Id
    var productId: Long? = null,

    @Id
    var infoFieldName: String? = null,

    @Id
    var infoFieldValue: String? = null
)

@Suppress("SerialVersionUIDInSerializableClass")
class ProductInfoEntityId(
    var productId: Long? = null,

    var infoFieldName: String? = null,

    var infoFieldValue: String? = null
) : Serializable
