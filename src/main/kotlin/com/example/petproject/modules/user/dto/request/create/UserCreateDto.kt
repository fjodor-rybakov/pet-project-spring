package com.example.petproject.modules.user.dto.request.create

import com.example.petproject.modules.user.entity.UserEntity
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class UserCreateDto {
        @NotBlank
        @NotEmpty(message = "Must be not empty")
        @Size(max = 30, message = "Max size must be less 30 symbols")
        val firstName: String = ""

        @NotBlank
        @NotEmpty(message = "Must be not empty")
        @Size(max = 30, message = "Max size must be less 30 symbols")
        val lastName: String = ""

        @Min(20, message = "Must be older 20")
        val age: Int? = null

        @NotBlank
        @NotEmpty(message = "Must be not empty")
        @Size(max = 30, message = "Max size must be less 30 symbols")
        val nickname: String = ""

        @NotBlank
        @NotEmpty(message = "Must be not empty")
        val password: String = ""
}

fun UserCreateDto.toUserEntity() = UserEntity(
        firstName = this.firstName,
        lastName = this.lastName,
        nickname = this.nickname,
        password = this.password
)

