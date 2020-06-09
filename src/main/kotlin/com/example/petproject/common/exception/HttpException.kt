package com.example.petproject.common.exception

import org.springframework.http.HttpStatus

data class HttpException(
        val message: String?,
        val httpStatus: HttpStatus
)