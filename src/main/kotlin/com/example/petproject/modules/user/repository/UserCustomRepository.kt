package com.example.petproject.modules.user.repository

import com.example.petproject.modules.user.dto.request.QueryDto
import com.example.petproject.modules.user.entity.UserEntity

interface UserCustomRepository {
    fun findUserByIdOrFail(id: Long): UserEntity

    fun findAllUserList(requestQuery: QueryDto): List<UserEntity>

    fun findUserNicknameAndPasswordOrFail(nickname: String, password: String): UserEntity
}