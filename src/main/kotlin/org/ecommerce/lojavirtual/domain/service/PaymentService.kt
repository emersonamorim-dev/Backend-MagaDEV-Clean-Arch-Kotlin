package org.ecommerce.lojavirtual.domain.service


import org.ecommerce.lojavirtual.application.controller.dto.PaymentResponse
import org.ecommerce.lojavirtual.domain.entity.PaymentEntity
import org.ecommerce.lojavirtual.domain.repository.CustomerRepository
import org.ecommerce.lojavirtual.domain.repository.PaymentRepository
import org.ecommerce.lojavirtual.infrastructure.listener.dto.PaymentCreatedEvent
import org.ecommerce.lojavirtual.utils.Constants
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*


@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val customerRepository: CustomerRepository
) {

    fun save(event: PaymentCreatedEvent): PaymentEntity {

        val newPaymentId = UUID.randomUUID()

        customerRepository.findById(event.customerId)
            .orElseThrow { IllegalArgumentException("Customer not found") }

        val payment = PaymentEntity(
            Id = newPaymentId,
            orderId = event.orderId,
            paymentId = event.paymentId,
            customerId = event.customerId,
            amount = event.amount,
            paymentDate = LocalDateTime.now(),
            status = event.status
        )

        return paymentRepository.save(payment)
    }



    fun getPaymentById(paymentId: UUID): PaymentResponse? {
        return paymentRepository.findById(paymentId).map {
            PaymentResponse.fromEntity(it)
        }.orElseThrow {
            throw Exception(Constants.PAYMENT_NOT_FOUND)
        }
    }


    fun getAllPayments(pageRequest: PageRequest): Page<PaymentResponse> {
        val payments = paymentRepository.findAll(pageRequest)
        return payments.map { PaymentResponse.fromEntity(it) }
    }

}
