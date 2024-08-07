package org.ecommerce.lojavirtual.infrastructure.listener

import org.ecommerce.lojavirtual.config.RabbitMqConfig
import org.ecommerce.lojavirtual.domain.service.CustomerService
import org.ecommerce.lojavirtual.infrastructure.listener.dto.CustomerCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class CustomerCreatedListener(
    private val customerService: CustomerService
) {
    private val logger = LoggerFactory.getLogger(CustomerCreatedListener::class.java)

//    @RabbitListener(queues = [RabbitMqConfig.CUSTOMER_CREATED_QUEUE])
//    fun listen(message: Message<CustomerCreatedEvent>) {
//        logger.info("Message consumed: {}", message)
//
//        customerService.save(message.payload)
//    }
}
