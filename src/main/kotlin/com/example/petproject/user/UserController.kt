package com.example.petproject.user

import com.example.petproject.user.dto.response.UserResponseDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["user"])
class UserController(
        private val userService: UserService
) {
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserResponseDto = userService.getUserById(id)
}