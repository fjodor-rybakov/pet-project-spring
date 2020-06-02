package com.example.petproject.user

import com.example.petproject.user.dto.response.toUserResponseDto
import com.example.petproject.user.repository.UserRepositoryImpl
import org.springframework.stereotype.Service

@Service
class UserService(
        private var userRepositoryImpl: UserRepositoryImpl
) {
    fun getUserById(id: Long) = this.userRepositoryImpl.findUserByIdOrFail(id).toUserResponseDto()
}