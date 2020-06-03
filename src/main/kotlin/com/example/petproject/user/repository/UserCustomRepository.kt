package com.example.petproject.user.repository

import com.example.petproject.user.entity.UserEntity

interface UserCustomRepository {
    fun findUserByIdOrFail(id: Long): UserEntity
}