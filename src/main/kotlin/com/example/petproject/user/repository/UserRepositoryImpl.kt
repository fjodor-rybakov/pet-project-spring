package com.example.petproject.user.repository

import com.example.petproject.user.entity.UserEntity
import com.example.petproject.user.exception.UserNotFoundException
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userRepository: UserRepository
) {
    fun findUserByIdOrFail(id: Long): UserEntity {
        val user = userRepository.findById(id)
        if (user.isEmpty) {
            throw UserNotFoundException()
        }
        return userRepository.findById(id).get()
    }
}