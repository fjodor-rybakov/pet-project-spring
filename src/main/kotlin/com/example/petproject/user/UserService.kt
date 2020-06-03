package com.example.petproject.user

import com.example.petproject.user.dto.response.toUserResponseDto
import com.example.petproject.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private var userRepository: UserRepository
) {
    fun getUserById(id: Long) = this.userRepository.findUserByIdOrFail(id).toUserResponseDto()
}