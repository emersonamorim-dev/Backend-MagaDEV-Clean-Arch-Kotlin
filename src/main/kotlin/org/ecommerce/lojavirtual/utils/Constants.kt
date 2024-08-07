package org.ecommerce.lojavirtual.utils

object Constants {
    const val ORDER_NOT_FOUND = "Order not found"
    const val USER_NOT_FOUND = "User not found"
    const val PRODUCT_NOT_FOUND = "Product not found"
    const val PAYMENT_NOT_FOUND = "Payment not found"
    const val NEW_ORDER_MESSAGE = "New order created with ID: "

    // RabbitMQ related constants
    const val ORDER_EXCHANGE = "order-exchange"
    const val ORDER_ROUTING_KEY = "order.routing.key"
    const val ORDER_STREAM = "order-stream"  // If n
}
