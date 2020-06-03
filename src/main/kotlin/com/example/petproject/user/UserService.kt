package com.example.petproject.user

import com.example.petproject.user.dto.request.QueryDto
import com.example.petproject.user.dto.response.UserResponseDto
import com.example.petproject.user.dto.response.toUserResponseDto
import com.example.petproject.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private var userRepository: UserRepository
) {
    fun getUserById(id: Long) = userRepository.findUserByIdOrFail(id).toUserResponseDto()

    fun getAllUserList(requestQuery: QueryDto) = userRepository.findAllUserList(requestQuery).map { it.toUserResponseDto() }

    fun createUser(): UserResponseDto {
        return UserResponseDto(1, "qwe", "qwe", 25)
    }
}