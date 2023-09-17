package ru.sharpbang.marketplaceback.baggins.repository.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false)
    var id: Long? = null,
    var firstName: String? = null,
    var surname: String? = null,
    var email: String? = null,
    var phone: String? = null
)
