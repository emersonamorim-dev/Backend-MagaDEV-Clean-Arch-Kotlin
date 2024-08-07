package org.ecommerce.lojavirtual.application.controller.dto

import org.springframework.data.domain.Page

data class PaginationResponse(
    val page: Int,
    val pageSize: Int,
    val totalElements: Long,
    val totalPages: Int
) {
    companion object {
        fun fromPage(page: Page<*>): PaginationResponse {
            return PaginationResponse(
                page = page.number,
                pageSize = page.size,
                totalElements = page.totalElements,
                totalPages = page.totalPages
            )
        }
    }
}
