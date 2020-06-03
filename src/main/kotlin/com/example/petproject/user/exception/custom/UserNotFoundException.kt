package com.example.petproject.user.exception.custom

open class UserNotFoundException(message: String? = "User not found") : RuntimeException(message)