package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.application.controller.dto.CreateCustomerRequest
import org.ecommerce.lojavirtual.application.controller.dto.CustomerResponse
import org.ecommerce.lojavirtual.application.controller.dto.UpdateCustomerRequest
import org.ecommerce.lojavirtual.domain.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Clientes")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun createCustomer(@RequestBody request: CreateCustomerRequest): ResponseEntity<CustomerResponse> {
        val savedCustomer = customerService.createCustomer(request)
        return ResponseEntity.ok(CustomerResponse.fromEntity(savedCustomer))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: UUID): ResponseEntity<CustomerResponse> {
        val customer = customerService.findById(id)
        return ResponseEntity.ok(customer)
    }

    @GetMapping
    fun listCustomers(@RequestParam(name = "page", defaultValue = "0") page: Int,
                      @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int): ResponseEntity<Page<CustomerResponse>> {
        val customers = customerService.listAll(page, pageSize)
        return ResponseEntity.ok(customers)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: UUID, @RequestBody updateRequest: UpdateCustomerRequest): ResponseEntity<Void> {
        customerService.update(id, updateRequest)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: UUID): ResponseEntity<Void> {
        customerService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
