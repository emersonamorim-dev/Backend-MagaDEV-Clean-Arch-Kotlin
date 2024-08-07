package org.ecommerce.lojavirtual.application.controller.dto

import java.util.UUID

data class CreateProductRequest(
    val name: String,
    val description: String,
    val price: Double,
    val brandId: UUID,
    val categoryId: UUID,
    val stateId: UUID
)

