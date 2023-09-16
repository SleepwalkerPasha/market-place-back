package ru.sharpbang.marketplaceback.baggins.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.sharpbang.marketplaceback.baggins.repository.entities.UserDto

@Suppress("EmptyClassBlock")
interface UserRepository: JpaRepository<UserDto, Long> {

}
