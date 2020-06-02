package com.example.petproject.user.dto.response

import com.example.petproject.user.entity.UserEntity

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