package com.example.petproject.common.exception

import org.hibernate.exception.ConstraintViolationException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class JPAExceptionAdvice {
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleSqlException(e: ConstraintViolationException) = ResponseEntity<HttpException>(
            HttpException(e.sqlException.toString(), HttpStatus.CONFLICT),
            HttpStatus.CONFLICT
    )
}