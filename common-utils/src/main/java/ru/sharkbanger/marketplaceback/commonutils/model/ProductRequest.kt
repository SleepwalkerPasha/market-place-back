package ru.sharkbanger.marketplaceback.commonutils.model

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.math.BigDecimal

data class NewProductRequest(
    @field:NotBlank
    @field:Pattern(regexp = "[a-zA-Zа-яА-Я]")
    val title: String,
    val description: String?,
    @field:DecimalMin(value = "0.0", inclusive = false)
    val price: BigDecimal,
    /*
    Должны ли мы здесь хранить только айдишники или, как в entity Images?
    Когда приходит запрос на добавление товра в restservice:
    Нам прилетают свойства товара и картинки
    restservice дерагет ручку baggins и добавляет картинки в БД
    В БД картинкам назначаются айдишники
    Но чтобы в JPA Entity product была связь с картинками необхдимо хранить Set<Images>, а не Set<Long>
    Хоть в самой БД связаны сущности будут оп айдишнику, но в JPA (да-да, не любим ее) они фиксруются именно как сет сущностей
    Поэтому рационально ли нам хранить здесь Set<Long>?
    */
    val picturesIds: Set<Long>?
)

data class UpdateProductRequest(
    @field:NotNull
    val id: Long,
    val title: String? = null,
    val description: String? = null,
    val price: BigDecimal? = null,
    val picturesIds: Set<Long>? = null
)