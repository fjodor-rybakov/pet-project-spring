package com.example.petproject.modules.user.repository

import com.example.petproject.modules.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<UserEntity, Long>, UserCustomRepository {
    fun findByNickname(nickname: String): Optional<UserEntity>

    fun findByNicknameAndPassword(nickname: String, password: String): Optional<UserEntity>
}