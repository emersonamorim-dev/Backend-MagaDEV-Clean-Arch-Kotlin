package org.ecommerce.lojavirtual.application.controller.dto

import java.util.UUID

data class UpdateCustomerRequest(
    val name: String?,
    val email: String?,
    val address: String?
)
