package org.ecommerce.lojavirtual.application.controller.dto

import org.ecommerce.lojavirtual.domain.entity.CustomerEntity
import java.util.UUID

data class CustomerResponse(
    val id: UUID?,
    val name: String?,
    val email: String?
) {
    companion object {
        fun fromEntity(entity: CustomerEntity): CustomerResponse {
            return CustomerResponse(
                id = entity.id,
                name = entity.name,
                email = entity.email
            )
        }
    }
}

