package com.example.petproject.common.exception

import com.example.petproject.modules.user.exception.UserNotFoundException
import org.hibernate.exception.ConstraintViolationException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*
import java.util.function.Consumer

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
class ExceptionAdvice {
    @ExceptionHandler(RuntimeException::class)
    fun handleRunTimeException(e: RuntimeException) = ResponseEntity<HttpException>(
            HttpException(e.message, HttpStatus.INTERNAL_SERVER_ERROR),
            HttpStatus.INTERNAL_SERVER_ERROR
    )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(e: MethodArgumentNotValidException): ResponseEntity<Map<String, HttpException>> {
        val errors: MutableMap<String, HttpException> = HashMap()
        e.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = HttpException(errorMessage, HttpStatus.BAD_REQUEST)
        })
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleNotFoundException(e: UserNotFoundException) = ResponseEntity<HttpException>(
            HttpException(e.message, HttpStatus.NOT_FOUND),
            HttpStatus.NOT_FOUND
    )
}
