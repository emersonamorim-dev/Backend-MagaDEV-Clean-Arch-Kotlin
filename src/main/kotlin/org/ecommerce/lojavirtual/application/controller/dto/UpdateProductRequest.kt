package org.ecommerce.lojavirtual.application.controller.dto

import java.util.UUID

data class UpdateProductRequest(
    val name: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val brandId: UUID? = null,
    val categoryId: UUID? = null,
    val stateId: UUID? = null
)

