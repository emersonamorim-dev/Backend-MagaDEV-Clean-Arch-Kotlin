package org.ecommerce.lojavirtual.application.controller.dto

data class ApiResponse<T>(
    val summary: Map<String, Any>,
    val data: List<T>,
    val pagination: PaginationResponse
)
