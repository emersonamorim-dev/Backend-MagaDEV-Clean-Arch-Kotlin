package org.ecommerce.lojavirtual.infrastructure.listener.dto

import java.util.UUID

data class CustomerCreatedEvent(
    val id: UUID? = null,
    val name: String,
    val email: String,
    val address: String,
    val items: List<CustomerItemEvent>
)
