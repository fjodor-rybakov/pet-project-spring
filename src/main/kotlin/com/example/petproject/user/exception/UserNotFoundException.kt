package com.example.petproject.user.exception

open class UserNotFoundException(message: String? = "User not found") : RuntimeException(message)