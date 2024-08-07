package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.application.controller.dto.ApiResponse
import org.ecommerce.lojavirtual.application.controller.dto.OrderResponse
import org.ecommerce.lojavirtual.application.controller.dto.PaginationResponse
import org.ecommerce.lojavirtual.domain.service.OrderService
import org.ecommerce.lojavirtual.infrastructure.listener.dto.OrderCreatedEvent
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Pedidos")
class OrderController(
    private val orderService: OrderService
) {
    @PostMapping
    fun createOrder(@RequestBody orderEvent: OrderCreatedEvent): ResponseEntity<Any> {
        return try {
            val savedOrder = orderService.save(orderEvent)
            ResponseEntity.ok(savedOrder)
        } catch (e: Exception) {
            ResponseEntity.badRequest().body("Error creating order: ${e.message}")
        }
    }

    @GetMapping("/{orderId}")
    fun getOrderById(@PathVariable orderId: UUID): ResponseEntity<OrderResponse> =
        orderService.getOrderById(orderId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @GetMapping
    fun listOrders(
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int
    ): ResponseEntity<ApiResponse<OrderResponse>> {
        val pageRequest = PageRequest.of(page, pageSize)
        val pageResponse = orderService.findAll(pageRequest)
        return ResponseEntity.ok(
            ApiResponse(
                summary = mapOf("totalOrders" to pageResponse.totalElements),
                data = pageResponse.content,
                pagination = PaginationResponse.fromPage(pageResponse)
            )
        )
    }
}
