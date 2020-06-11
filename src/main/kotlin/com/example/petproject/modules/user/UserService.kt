package com.example.petproject.modules.user

import com.example.petproject.common.dto.MessageResponseDto
import com.example.petproject.modules.user.dto.request.QueryDto
import com.example.petproject.modules.user.dto.request.create.UserCreateDto
import com.example.petproject.modules.user.dto.request.create.toUserEntity
import com.example.petproject.modules.user.dto.request.update.UserUpdateDto
import com.example.petproject.modules.user.dto.response.UserResponseDto
import com.example.petproject.modules.user.dto.response.toUserResponseDto
import com.example.petproject.modules.user.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val modelMapper: ModelMapper
) {
    fun getUserById(id: Long) = userRepository.findUserByIdOrFail(id).toUserResponseDto()

    fun getAllUserList(requestQuery: QueryDto) = userRepository.findAllUserList(requestQuery)
            .map { it.toUserResponseDto() }

    fun createUser(newUserData: UserCreateDto): UserResponseDto {
        val userEntity = newUserData.toUserEntity()
        userEntity.age = newUserData.age
        return this.userRepository.save(userEntity).toUserResponseDto()
    }

    fun updateUser(id: Long, updateDto: UserUpdateDto): UserResponseDto {
        val currentUserEntity = this.userRepository.findUserByIdOrFail(id)
        modelMapper.map(updateDto, currentUserEntity)
        return this.userRepository.save(currentUserEntity).toUserResponseDto()
    }

    fun deleteUser(id: Long): MessageResponseDto {
        val currentUserEntity = this.userRepository.findUserByIdOrFail(id)
        this.userRepository.delete(currentUserEntity)
        return MessageResponseDto("User success deleted!")
    }
}