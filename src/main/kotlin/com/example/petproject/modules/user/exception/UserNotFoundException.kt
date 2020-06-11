package com.example.petproject.modules.user.exception

open class UserNotFoundException(message: String? = "User not found") : RuntimeException(message)