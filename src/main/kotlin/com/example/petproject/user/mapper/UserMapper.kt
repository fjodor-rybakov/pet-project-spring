package com.example.petproject.user.mapper

import com.example.petproject.user.dto.request.update.UserUpdateDto
import com.example.petproject.user.entity.UserEntity
import org.modelmapper.PropertyMap

class UserMapper : PropertyMap<UserUpdateDto, UserEntity>() {
    override fun configure() {
        skip().age = 12
    }
}