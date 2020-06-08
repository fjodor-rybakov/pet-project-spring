package com.example.petproject.user

import com.example.petproject.user.dto.request.QueryDto
import com.example.petproject.user.dto.request.create.UserCreateDto
import com.example.petproject.user.dto.response.UserResponseDto
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("user")
class UserController(
        private val userService: UserService
) {
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserResponseDto = userService.getUserById(id)

    @GetMapping
    fun getAllUserList(
            @ModelAttribute
            requestQuery: QueryDto
    ): List<UserResponseDto> = userService.getAllUserList(requestQuery)

    @PostMapping
    fun createUser(@Valid @RequestBody newUserData: UserCreateDto): UserResponseDto =
        userService.createUser(newUserData)
}