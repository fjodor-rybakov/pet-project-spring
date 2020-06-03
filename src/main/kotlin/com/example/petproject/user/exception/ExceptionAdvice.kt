package com.example.petproject.user.exception

import com.example.petproject.user.exception.custom.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionAdvice {
    @ExceptionHandler(RuntimeException::class)
    fun handleRunTimeException(e: RuntimeException) = ResponseEntity<HttpException>(
            HttpException(e.message, HttpStatus.INTERNAL_SERVER_ERROR),
            HttpStatus.INTERNAL_SERVER_ERROR
    )

    @ExceptionHandler(UserNotFoundException::class)
    fun handleNotFoundException(e: UserNotFoundException) = ResponseEntity<HttpException>(
            HttpException(e.message, HttpStatus.NOT_FOUND),
            HttpStatus.NOT_FOUND
    )
}
