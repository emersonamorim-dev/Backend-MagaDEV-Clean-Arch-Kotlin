package org.ecommerce.lojavirtual.domain.service

import org.ecommerce.lojavirtual.domain.entity.StateEntity
import org.ecommerce.lojavirtual.domain.repository.StateRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StateService(
    private val stateRepository: StateRepository
) {
    fun getAllStates(): List<StateEntity> = stateRepository.findAll()

    fun getStateById(id: UUID): StateEntity? = stateRepository.findById(id).orElse(null)

    fun createState(state: StateEntity): StateEntity = stateRepository.save(state)

    fun updateState(id: UUID, state: StateEntity): StateEntity? {
        return if (stateRepository.existsById(id)) {
            stateRepository.save(state.copy(id = id))
        } else {
            null
        }
    }

    fun deleteState(id: UUID) {
        if (stateRepository.existsById(id)) {
            stateRepository.deleteById(id)
        }
    }
}