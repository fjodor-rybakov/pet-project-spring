package com.example.petproject.modules.user.repository

import com.example.petproject.modules.user.dto.request.QueryDto
import com.example.petproject.modules.user.entity.UserEntity
import com.example.petproject.modules.user.exception.UserNotFoundException
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class UserCustomRepositoryImpl(
        private val userRepository: UserRepository,
        private val entityManager: EntityManager
) : UserCustomRepository {
    override fun findUserByIdOrFail(id: Long): UserEntity =
            userRepository.findById(id).orElseThrow { UserNotFoundException() }

    override fun findAllUserList(requestQuery: QueryDto): List<UserEntity> {
        val cb = entityManager.criteriaBuilder
        val query: CriteriaQuery<UserEntity> = cb.createQuery(UserEntity::class.java)
        val user: Root<UserEntity> = query.from(UserEntity::class.java)

        if (requestQuery.search !== null && requestQuery.search.isNotEmpty()) {
            val predicateForFirstName = cb.like(user.get("firstName"), requestQuery.search + "%")
            query.where(predicateForFirstName)
        }

        return entityManager.createQuery(query).resultList
    }

    override fun findUserNicknameAndPasswordOrFail(nickname: String, password: String): UserEntity =
            userRepository.findByNicknameAndPassword(nickname, password).orElseThrow { UserNotFoundException() }
}