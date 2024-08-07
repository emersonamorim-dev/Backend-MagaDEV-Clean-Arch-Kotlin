package org.ecommerce.lojavirtual.infrastructure.listener

import org.ecommerce.lojavirtual.config.RabbitMqConfig
import org.ecommerce.lojavirtual.domain.service.OrderService
import org.ecommerce.lojavirtual.infrastructure.listener.dto.OrderCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class OrderCreatedListener(
    private val orderService: OrderService
) {
    private val logger = LoggerFactory.getLogger(OrderCreatedListener::class.java)

    @RabbitListener(queues = [RabbitMqConfig.ORDER_CREATED_QUEUE])
    fun listen(message: Message<OrderCreatedEvent>) {
        logger.info("Message consumed: {}", message)

        // Use message.payload to get the OrderCreatedEvent from the Message object
        orderService.save(message.payload)
    }
}
