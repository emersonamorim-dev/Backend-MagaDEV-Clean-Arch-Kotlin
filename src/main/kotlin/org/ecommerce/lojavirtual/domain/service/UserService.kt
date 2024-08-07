package org.ecommerce.lojavirtual.domain.service

import org.ecommerce.lojavirtual.application.dto.UserDto
import org.ecommerce.lojavirtual.domain.repository.UserRepository
import org.ecommerce.lojavirtual.infrastructure.adpter.UserAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun registerUser(userDto: UserDto, rawPassword: String): UserDto {
        val encryptedPassword = passwordEncoder.encode(rawPassword)
        val user = UserAdapter.toEntity(userDto).copy(password = encryptedPassword)
        val savedUser = userRepository.save(user)
        return UserAdapter.toDto(savedUser)
    }

    fun getUserByUsername(username: String): UserDto? {
        val user = userRepository.findByUsername(username) ?: return null
        return UserAdapter.toDto(user)
    }
}