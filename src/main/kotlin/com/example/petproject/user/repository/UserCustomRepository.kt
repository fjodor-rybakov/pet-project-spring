package com.example.petproject.user.repository

import com.example.petproject.user.dto.request.QueryDto
import com.example.petproject.user.entity.UserEntity

interface UserCustomRepository {
    fun findUserByIdOrFail(id: Long): UserEntity

    fun findAllUserList(requestQuery: QueryDto): List<UserEntity>
}