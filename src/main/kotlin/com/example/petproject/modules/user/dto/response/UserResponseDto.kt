package com.example.petproject.modules.user.dto.response

import com.example.petproject.modules.user.entity.UserEntity

data class UserResponseDto(
        val id: Long,
        val firstName: String,
        val lastName: String,
        val age: Int?
)

fun UserEntity.toUserResponseDto() = UserResponseDto(
        id = this.id,
        age = this.age,
        firstName = this.firstName,
        lastName = this.lastName
)