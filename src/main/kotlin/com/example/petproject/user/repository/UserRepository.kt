package com.example.petproject.user.repository

import com.example.petproject.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.lang.Exception

@Repository
interface UserRepository : CrudRepository<UserEntity, Long>