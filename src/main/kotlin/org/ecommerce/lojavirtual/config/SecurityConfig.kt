package org.ecommerce.lojavirtual.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests { auth ->
                auth
                    .anyRequest().authenticated()
            }
            .httpBasic()
        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val userDetailsManager = InMemoryUserDetailsManager()
        userDetailsManager.createUser(
            User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER")
                .build()
        )
        return userDetailsManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}