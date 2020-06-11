package com.example.petproject.modules.jwt

import com.example.petproject.modules.jwt.dto.request.JwtRequestDto
import com.example.petproject.modules.jwt.dto.response.JwtResponseDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@CrossOrigin
class JwtAuthenticationController(
        private val jwtTokenUtil: JwtTokenUtil,
        private val userDetailsService: JwtUserDetailsService,
        private val authenticationManager: AuthenticationManager
) {
    @PostMapping("authenticate")
    fun createAuthenticationToken(@Valid @RequestBody authenticationRequestDto: JwtRequestDto): JwtResponseDto {
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(authenticationRequestDto.username)
        authenticate(authenticationRequestDto.username, authenticationRequestDto.password)
        val token = jwtTokenUtil.generateToken(userDetails)
        return JwtResponseDto(token)
    }

    @Throws(Exception::class)
    private fun authenticate(username: String, password: String) {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
    }
}