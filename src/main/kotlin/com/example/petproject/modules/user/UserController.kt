package com.example.petproject.modules.user

import com.example.petproject.common.dto.MessageResponseDto
import com.example.petproject.modules.user.dto.request.QueryDto
import com.example.petproject.modules.user.dto.request.create.UserCreateDto
import com.example.petproject.modules.user.dto.request.update.UserUpdateDto
import com.example.petproject.modules.user.dto.response.UserResponseDto
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.util.*
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
            @ModelAttribute requestQuery: QueryDto
    ): List<UserResponseDto> = userService.getAllUserList(requestQuery)

    @PostMapping
    fun createUser(
            @Valid @RequestBody newUserData: UserCreateDto
    ): UserResponseDto = userService.createUser(newUserData)

    @PutMapping("{id}")
    fun updateUser(
            @PathVariable id: Long,
            @Valid @RequestBody updateDto: UserUpdateDto
    ): UserResponseDto = userService.updateUser(id, updateDto)

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: Long): MessageResponseDto = userService.deleteUser(id)
}