package ru.sharpbang.marketplaceback.baggins.domain

import org.springframework.stereotype.Service
import ru.sharpbang.marketplaceback.baggins.port.UserPort
import ru.sharpbang.marketplaceback.baggins.repository.UserRepository
import ru.sharpbang.marketplaceback.baggins.support.mapper.UserMapper
import ru.sharpbang.marketplaceback.baggins.support.utils.NotFoundException

@Service
class UserUseCase(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserPort {

    override fun getUserById(id: Long) =
        userMapper.toModel(
            userRepository.findById(id).orElseThrow { throw NotFoundException("user with $id not found") })
}