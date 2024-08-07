package org.ecommerce.lojavirtual.utils

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException, request: WebRequest): ResponseEntity<Any> {
        val errorDetails = mapOf(
            "timestamp" to System.currentTimeMillis(),
            "message" to ex.localizedMessage,
            "details" to request.getDescription(false)
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        val errorDetails = mapOf(
            "timestamp" to System.currentTimeMillis(),
            "message" to ex.localizedMessage,
            "details" to request.getDescription(false)
        )
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
