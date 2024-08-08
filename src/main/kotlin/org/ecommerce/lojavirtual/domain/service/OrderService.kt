package org.ecommerce.lojavirtual.domain.service

import org.ecommerce.lojavirtual.application.controller.dto.*
import org.ecommerce.lojavirtual.domain.entity.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.ecommerce.lojavirtual.domain.repository.*
import org.ecommerce.lojavirtual.infrastructure.listener.dto.OrderCreatedEvent
import org.ecommerce.lojavirtual.utils.Constants
import java.time.LocalDateTime
import java.util.UUID

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository,
) {

    fun save(event: OrderCreatedEvent): OrderEntity {
        // Gera um UUID único para cada novo pedido.
        val newOrderId = UUID.randomUUID()

        // Cria um novo pedido com o UUID gerado.
        val order = OrderEntity(
            id = newOrderId, // O ID do pedido é gerado automaticamente aqui.
            customerId = event.customerId,
            totalPrice = event.totalPrice,
            orderDate = LocalDateTime.now(),
            status = event.status
        )

        // Salva o novo pedido no banco de dados.
        return orderRepository.save(order)
    }


    fun getOrderById(orderId: UUID): OrderResponse? {
        return orderRepository.findById(orderId).map {
            OrderResponse.fromEntity(it)
        }.orElseThrow {
            throw Exception(Constants.ORDER_NOT_FOUND)
        }
    }

    fun findAll(pageRequest: PageRequest): Page<OrderResponse> {
        val orders = orderRepository.findAll(pageRequest)
        return orders.map { OrderResponse.fromEntity(it) }
    }

    fun getAllOrders(pageRequest: PageRequest): Page<OrderResponse> {
        val payments = orderRepository.findAll(pageRequest)
        return payments.map { OrderResponse.fromEntity(it) }
    }

}



