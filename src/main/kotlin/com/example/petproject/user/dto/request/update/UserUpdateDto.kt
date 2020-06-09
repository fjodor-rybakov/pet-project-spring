package com.example.petproject.user.dto.request.update

import javax.validation.constraints.Min
import javax.validation.constraints.Size

class UserUpdateDto {
    @Size(max = 30, message = "Max size must be less 30 symbols")
    val firstName: String? = null

    @Size(max = 30, message = "Max size must be less 30 symbols")
    val lastName: String? = null

    @Min(20, message = "Must be older 20")
    val age: Int? = null
}