package com.example.petproject.user

import com.example.petproject.common.dto.MessageResponseDto
import com.example.petproject.user.dto.request.QueryDto
import com.example.petproject.user.dto.request.create.UserCreateDto
import com.example.petproject.user.dto.request.create.toUserEntity
import com.example.petproject.user.dto.request.update.UserUpdateDto
import com.example.petproject.user.dto.response.UserResponseDto
import com.example.petproject.user.dto.response.toUserResponseDto
import com.example.petproject.user.entity.UserEntity
import com.example.petproject.user.repository.UserRepository
import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.springframework.stereotype.Service

@Service
class UserService(
        private var userRepository: UserRepository
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
        mapUserUpdateDtoToUserEntity(updateDto, currentUserEntity)
        return this.userRepository.save(currentUserEntity).toUserResponseDto()
    }

    fun deleteUser(id: Long): MessageResponseDto {
        val currentUserEntity = this.userRepository.findUserByIdOrFail(id)
        this.userRepository.delete(currentUserEntity)
        return MessageResponseDto("User success deleted!")
    }

    private fun mapUserUpdateDtoToUserEntity(updateDto: UserUpdateDto, currentUserEntity: UserEntity) {
        val modelMapper = ModelMapper()
        modelMapper.configuration
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .fieldAccessLevel = Configuration.AccessLevel.PRIVATE
        modelMapper.map(updateDto, currentUserEntity)
    }
}