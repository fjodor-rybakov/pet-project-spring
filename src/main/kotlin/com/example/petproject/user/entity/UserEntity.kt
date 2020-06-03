package com.example.petproject.user.entity

import javax.persistence.*

@Entity
@Table(name="`user`")
class UserEntity(
        val firstName: String,
        val lastName: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    var age: Int? = null
}