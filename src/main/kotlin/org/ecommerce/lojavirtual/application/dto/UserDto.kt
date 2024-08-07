package org.ecommerce.lojavirtual.application.dto

import java.util.UUID

data class UserDto(
    val id: UUID?,
    val username: String,
    val email: String
)
