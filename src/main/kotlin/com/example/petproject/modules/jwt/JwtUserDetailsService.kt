package com.example.petproject.modules.jwt

import com.example.petproject.modules.user.entity.UserEntity
import com.example.petproject.modules.user.exception.UserNotFoundException
import com.example.petproject.modules.user.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class JwtUserDetailsService(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val person: UserEntity = userRepository.findByNickname(username).orElseThrow {UserNotFoundException()}
        return User(person.firstName, person.password, ArrayList())
    }
}