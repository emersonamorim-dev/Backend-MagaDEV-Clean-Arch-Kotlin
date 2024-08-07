package org.ecommerce.lojavirtual.config

import org.springframework.amqp.core.Declarable
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfig {

    companion object {
        const val ORDER_CREATED_QUEUE = "ecommerce-lojavirtual-order-created"
        const val CUSTOMER_CREATED_QUEUE = "ecommerce-lojavirtual-customer-created"
        const val PAYMENT_CREATED_QUEUE = "ecommerce-lojavirtual-payment-created"
    }

    @Bean
    fun jackson2JsonMessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun orderCreatedQueue(): Declarable {
        return Queue(ORDER_CREATED_QUEUE)
    }

    @Bean
    fun customerCreatedQueue(): Declarable {
        return Queue(CUSTOMER_CREATED_QUEUE)
    }

    @Bean
    fun paymentCreatedQueue(): Declarable {
        return Queue(PAYMENT_CREATED_QUEUE)
    }
}

