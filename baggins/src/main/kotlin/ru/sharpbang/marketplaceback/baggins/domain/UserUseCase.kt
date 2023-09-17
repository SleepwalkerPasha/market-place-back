package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.model.request.NewUserRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateUserRequest
import ru.sharpbang.marketplaceback.baggins.model.response.CustomerInfoResponse
import ru.sharpbang.marketplaceback.baggins.model.response.SellerInfoResponse
import ru.sharpbang.marketplaceback.baggins.model.response.UserInfoResponse
import ru.sharpbang.marketplaceback.baggins.port.UserPort
import ru.sharpbang.marketplaceback.baggins.repository.CustomerRepository
import ru.sharpbang.marketplaceback.baggins.repository.SellerRepository
import ru.sharpbang.marketplaceback.baggins.repository.UserRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.CustomerEntity
import ru.sharpbang.marketplaceback.baggins.repository.entities.SellerEntity
import ru.sharpbang.marketplaceback.baggins.repository.entities.UserEntity
import ru.sharpbang.marketplaceback.baggins.support.mapper.UserMapper
import ru.sharpbang.marketplaceback.baggins.support.utils.NotFoundException

@Service
class UserUseCase(
    private val userRepository: UserRepository,
    private val customerRepository: CustomerRepository,
    private val sellerRepository: SellerRepository,
    private val userMapper: UserMapper
) : UserPort {
    override fun getUserInfo(id: Long): UserInfoResponse =
        userRepository.findById(id).orElseThrow { throw NotFoundException("user with $id not found") }.run {
            userMapper.toModel(this)
        }

    override fun getCustomerInfo(id: Long): CustomerInfoResponse =
        getUserInfo(id).toCustomerInfoResponse(
            customerRepository.findById(id).orElseThrow { throw NotFoundException("user with $id not found") }
        )

    override fun getSellerInfo(id: Long): SellerInfoResponse =
        getUserInfo(id).toSellerInfoResponse(
            sellerRepository.findById(id).orElseThrow { throw NotFoundException("user with $id not found") }
        )

    override fun registerNewUser(newUserRequest: NewUserRequest) =
        userRepository.save(newUserRequest.toEntity()).run { userMapper.toModel(this) }

    override fun updateUserInfo(updateUserRequest: UpdateUserRequest) =
        userRepository.save(
            getUserInfo(updateUserRequest.id).run {
                updateUserRequest.toEntity(this)
            }
        ).run { userMapper.toModel(this) }

}

private fun UpdateUserRequest.toEntity(oldUserInfo: UserInfoResponse) = UserEntity(
    id = this.id,
    firstName = this.firstName ?: oldUserInfo.firstName,
    surname = this.surname ?: oldUserInfo.surname,
    email = this.email ?: oldUserInfo.email,
    phone = this.phone ?: oldUserInfo.phone,
)

private fun NewUserRequest.toEntity() = UserEntity(
    firstName = this.firstName,
    surname = this.surname,
    email = this.email,
    phone = this.phone,
)

private fun UserInfoResponse.toSellerInfoResponse(sellerEntity: SellerEntity) = SellerInfoResponse(
    id = this.id,
    firstName = this.firstName,
    surname = this.surname,
    email = this.email,
    phone = this.phone,
    salesAmount = sellerEntity.salesAmount
)

private fun UserInfoResponse.toCustomerInfoResponse(customerEntity: CustomerEntity) = CustomerInfoResponse(
    id = this.id,
    firstName = this.firstName,
    surname = this.surname,
    email = this.email,
    phone = this.phone,
    ransomAmount = customerEntity.ransomAmount
)
