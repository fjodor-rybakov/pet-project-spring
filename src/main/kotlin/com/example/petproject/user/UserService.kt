package com.example.petproject.user

import com.example.petproject.user.dto.response.UserResponseDto
import com.example.petproject.user.dto.response.toUserResponseDto
import com.example.petproject.user.exception.UserNotFoundException
import com.example.petproject.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(
        private var userRepository: UserRepository
) {
    fun getUserById(id: Long): UserResponseDto {
        val user = this.userRepository.findById(id)
        if (user.isEmpty) {
            throw UserNotFoundException()
        }
        return this.userRepository.findById(id).get().toUserResponseDto()
    }
}