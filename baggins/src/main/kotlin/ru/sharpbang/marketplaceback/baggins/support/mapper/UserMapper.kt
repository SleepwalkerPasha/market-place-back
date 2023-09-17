package ru.sharpbang.marketplaceback.baggins.support.mapper

import org.mapstruct.Mapper
import ru.sharpbang.marketplaceback.baggins.model.response.UserInfoResponse
import ru.sharpbang.marketplaceback.baggins.repository.entities.UserEntity

@Mapper
interface UserMapper {

    fun toEntity(userInfoResponse: UserInfoResponse): UserEntity

    fun toModel(userEntity: UserEntity): UserInfoResponse
}
