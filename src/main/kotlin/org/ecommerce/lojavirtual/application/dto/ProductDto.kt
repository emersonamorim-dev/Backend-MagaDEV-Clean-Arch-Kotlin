package org.ecommerce.lojavirtual.application.dto

import java.util.UUID

data class ProductDTO(
    val id: UUID,
    val name: String,
    val description: String,
    val price: Number,
    val category: CategoryDTO,
    val brand: BrandDTO,
    val state: StateDTO
)

data class CategoryDTO(val id: UUID, val name: String)
data class BrandDTO(val id: UUID, val name: String)
data class StateDTO(val id: UUID, val name: String)