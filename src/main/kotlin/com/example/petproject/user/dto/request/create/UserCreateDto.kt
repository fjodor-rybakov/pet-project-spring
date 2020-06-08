package com.example.petproject.user.dto.request.create

import com.example.petproject.user.entity.UserEntity
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class UserCreateDto {
        @NotEmpty(message = "Must be not empty")
        @Size(max = 30, message = "Max size must be less 30 symbols")
        val firstName: String = ""

        @NotEmpty(message = "Must be not empty")
        @Size(max = 30, message = "Max size must be less 30 symbols")
        val lastName: String = ""

        @Min(20, message = "Must be older 20")
        val age: Int? = null
}

fun UserCreateDto.toUserEntity() = UserEntity(
        firstName = this.firstName,
        lastName = this.lastName
)