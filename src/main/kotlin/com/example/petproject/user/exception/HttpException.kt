package com.example.petproject.user.exception

import org.springframework.http.HttpStatus

data class HttpException(
        val message: String?,
        val httpStatus: HttpStatus
)