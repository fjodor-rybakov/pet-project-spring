package com.example.petproject.user.repository

import com.example.petproject.user.entity.UserEntity
import com.example.petproject.user.exception.custom.UserNotFoundException
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userRepository: UserRepository
) {
    fun findUserByIdOrFail(id: Long): UserEntity =
        userRepository.findById(id).orElseThrow { UserNotFoundException() }
}