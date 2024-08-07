package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.application.dto.UserDto
import org.ecommerce.lojavirtual.domain.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuarios")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun registerUser(@RequestBody userDto: UserDto, @RequestParam rawPassword: String): ResponseEntity<UserDto> {
        return try {
            val registeredUser = userService.registerUser(userDto, rawPassword)
            ResponseEntity.ok(registeredUser)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{username}")
    fun getUserByUsername(@PathVariable username: String): ResponseEntity<UserDto> {
        val userDto = userService.getUserByUsername(username)
        return userDto?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
}
