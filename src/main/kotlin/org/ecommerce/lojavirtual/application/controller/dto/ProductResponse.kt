package org.ecommerce.lojavirtual.application.controller.dto

import org.ecommerce.lojavirtual.domain.entity.ProductEntity
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String,
    val description: String?,
    val price: Double,
    val brandName: String,
    val categoryName: String,
    val stateName: String
) {
    companion object {
        fun fromEntity(entity: ProductEntity): ProductResponse {
            // Throw exception if id is null
            val productId = entity.id ?: throw IllegalArgumentException("Product ID cannot be null")

            return ProductResponse(
                id = productId,
                name = entity.name,
                description = entity.description,
                price = entity.price,
                brandName = entity.brand.name,
                categoryName = entity.category.name,
                stateName = entity.state.name
            )
        }
    }
}

