package org.ecommerce.lojavirtual.domain.service

import org.ecommerce.lojavirtual.application.controller.dto.CreateCustomerRequest
import org.ecommerce.lojavirtual.application.controller.dto.CustomerResponse
import org.ecommerce.lojavirtual.application.controller.dto.UpdateCustomerRequest
import org.ecommerce.lojavirtual.domain.entity.CustomerEntity
import org.ecommerce.lojavirtual.domain.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    fun createCustomer(request: CreateCustomerRequest): CustomerEntity {
        val newCustomer = CustomerEntity(
            id = UUID.randomUUID(),
            name = request.name,
            email = request.email,
            address = request.address
        )
        return customerRepository.save(newCustomer)
    }

    fun findById(id: UUID): CustomerResponse {
        val customer = customerRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found") }
        return CustomerResponse.fromEntity(customer)
    }

    fun listAll(page: Int, pageSize: Int): Page<CustomerResponse> {
        val pageRequest = PageRequest.of(page, pageSize)
        return customerRepository.findAll(pageRequest)
            .map(CustomerResponse::fromEntity)
    }

    fun update(id: UUID, request: UpdateCustomerRequest) {
        val customer = customerRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found") }
        customer.apply {
            name = request.name ?: name
            email = request.email ?: email
            address = request.address ?: address
        }
        customerRepository.save(customer)
    }

    fun deleteById(id: UUID) {
        if (!customerRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")
        }
        customerRepository.deleteById(id)
    }
}

