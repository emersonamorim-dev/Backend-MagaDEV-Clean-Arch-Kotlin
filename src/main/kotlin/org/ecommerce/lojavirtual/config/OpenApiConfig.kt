package org.ecommerce.lojavirtual.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Backend Loja Virtual Application")
                    .version("1.0")
                    .description("Aplicação em Kotlin com Postres e RabbitMQ - EmerDev")
            )
    }
}
