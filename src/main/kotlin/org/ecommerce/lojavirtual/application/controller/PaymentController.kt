package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.application.controller.dto.ApiResponse
import org.ecommerce.lojavirtual.application.controller.dto.PaginationResponse
import org.ecommerce.lojavirtual.application.controller.dto.PaymentResponse
import org.ecommerce.lojavirtual.domain.service.PaymentService
import org.ecommerce.lojavirtual.infrastructure.listener.dto.PaymentCreatedEvent
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Pagamentos")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping
    fun createPayment(@RequestBody paymentEvent: PaymentCreatedEvent): ResponseEntity<Any> {
        return try {
            val savedPayment = paymentService.save(paymentEvent)
            ResponseEntity.ok(savedPayment)
        } catch (e: Exception) {
            ResponseEntity.badRequest().body("Error creating payment: ${e.message}")
        }
    }

    @GetMapping("/{paymentId}")
    fun getPaymentById(@PathVariable paymentId: UUID): ResponseEntity<PaymentResponse> =
        paymentService.getPaymentById(paymentId)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @GetMapping
    fun listPayments(@RequestParam(name = "page", defaultValue = "0") page: Int,
                     @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int): ResponseEntity<ApiResponse<PaymentResponse>> {
        val pageRequest = PageRequest.of(page, pageSize)
        val pageResponse = paymentService.getAllPayments(pageRequest)
        return ResponseEntity.ok(
            ApiResponse(
                summary = mapOf("totalPayments" to pageResponse.totalElements),
                data = pageResponse.content,
                pagination = PaginationResponse.fromPage(pageResponse)
            )
        )
    }
}
