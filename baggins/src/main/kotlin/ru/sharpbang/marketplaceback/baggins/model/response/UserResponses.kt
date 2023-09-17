package ru.sharpbang.marketplaceback.baggins.model.response

import java.math.BigDecimal

open class UserInfoResponse(
    open val id: Long,
    open val firstName: String,
    open val surname: String,
    open val email: String,
    open val phone: String
)

data class CustomerInfoResponse(
    override val id: Long,
    override val firstName: String,
    override val surname: String,
    override val email: String,
    override val phone: String,
    val ransomAmount: BigDecimal? = null
) : UserInfoResponse(id, firstName, surname, email, phone)

data class SellerInfoResponse(
    override val id: Long,
    override val firstName: String,
    override val surname: String,
    override val email: String,
    override val phone: String,
    val salesAmount: BigDecimal? = null
) : UserInfoResponse(id, firstName, surname, email, phone)
