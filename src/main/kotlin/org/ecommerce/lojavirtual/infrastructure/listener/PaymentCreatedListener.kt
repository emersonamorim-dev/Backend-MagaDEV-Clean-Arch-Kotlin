package org.ecommerce.lojavirtual.infrastructure.listener

import org.ecommerce.lojavirtual.config.RabbitMqConfig
import org.ecommerce.lojavirtual.domain.service.PaymentService
import org.ecommerce.lojavirtual.infrastructure.listener.dto.PaymentCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class PaymentCreatedListener(
    private val paymentService: PaymentService
) {
    private val logger = LoggerFactory.getLogger(PaymentCreatedListener::class.java)

    @RabbitListener(queues = [RabbitMqConfig.PAYMENT_CREATED_QUEUE])
    fun listen(message: Message<PaymentCreatedEvent>) {
        logger.info("Message consumed: {}", message)

        paymentService.save(message.payload)
    }
}