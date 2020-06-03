package com.example.petproject.user.repository

import com.example.petproject.user.entity.UserEntity
import com.example.petproject.user.exception.custom.UserNotFoundException

class UserCustomRepositoryImpl(
        private val userRepository: UserRepository
) : UserCustomRepository {
    override fun findUserByIdOrFail(id: Long): UserEntity =
            userRepository.findById(id).orElseThrow { UserNotFoundException() }
}