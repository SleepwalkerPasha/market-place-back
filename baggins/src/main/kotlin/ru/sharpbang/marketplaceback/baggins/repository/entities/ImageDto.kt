package ru.sharpbang.marketplaceback.baggins.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import java.sql.Types

@Entity
@Table(name = "images")
class ImageDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    @JdbcTypeCode(Types.LONGVARBINARY)
    @Lob
    var content: ByteArray? = null
)
