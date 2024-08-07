package org.ecommerce.lojavirtual.config

import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun publicApi(): GroupedOpenApi = GroupedOpenApi.builder()
        .group("springdoc")
        .packagesToScan("org.ecommerce.lojavirtual.application.controller")
        .build()
}



