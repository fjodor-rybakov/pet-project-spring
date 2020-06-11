package com.example.petproject.modules.jwt.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

class JwtRequestDto {
    @NotBlank
    @NotEmpty(message = "Must be not empty")
    var username: String = ""
    @NotBlank
    @NotEmpty(message = "Must be not empty")
    var password: String = ""
}