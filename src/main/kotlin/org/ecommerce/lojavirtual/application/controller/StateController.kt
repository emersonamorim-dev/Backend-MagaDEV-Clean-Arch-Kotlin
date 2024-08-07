package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.domain.entity.StateEntity
import org.ecommerce.lojavirtual.domain.service.StateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/states")
@Tag(name = "Estados")
class StateController(
    private val stateService: StateService
) {
    @GetMapping
    fun getAllStates(): ResponseEntity<List<StateEntity>> {
        return ResponseEntity.ok(stateService.getAllStates())
    }

    @GetMapping("/{id}")
    fun getStateById(@PathVariable id: UUID): ResponseEntity<StateEntity> {
        val state = stateService.getStateById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(state)
    }

    @PostMapping
    fun createState(@RequestBody state: StateEntity): ResponseEntity<StateEntity> {
        val newState = stateService.createState(state)
        return ResponseEntity.ok(newState)
    }

    @PutMapping("/{id}")
    fun updateState(@PathVariable id: UUID, @RequestBody state: StateEntity): ResponseEntity<StateEntity> {
        val updatedState = stateService.updateState(id, state) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedState)
    }

    @DeleteMapping("/{id}")
    fun deleteState(@PathVariable id: UUID): ResponseEntity<Void> {
        stateService.deleteState(id)
        return ResponseEntity.noContent().build()
    }
}