package org.ecommerce.lojavirtual.infrastructure.adpter

import org.ecommerce.lojavirtual.application.dto.UserDto
import org.ecommerce.lojavirtual.domain.entity.UserEntity
import java.util.UUID

object UserAdapter {

    fun toEntity(userDto: UserDto): UserEntity {
        return UserEntity(
            id = userDto.id ?: UUID.randomUUID(),
            username = userDto.username,
            password = "", // A senha deve ser tratada separadamente
            email = userDto.email
        )
    }

    fun toDto(user: UserEntity): UserDto {
        return UserDto(
            id = user.id,
            username = user.username,
            email = user.email
        )
    }
}
