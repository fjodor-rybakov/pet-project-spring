package com.example.petproject.user.repository

import com.example.petproject.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long>, UserCustomRepository {

}