package com.example.petproject.modules.user.entity

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "`user`")
class UserEntity(
        @Column(name = "first_name")
        val firstName: String,

        @Column(name = "last_name")
        val lastName: String,

        @Column(unique = true)
        val nickname: String,

        var password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    var age: Int? = null

    @PreUpdate
    @PrePersist
    fun updatePassword() {
        this.password = BCryptPasswordEncoder().encode(this.password)
    }
}