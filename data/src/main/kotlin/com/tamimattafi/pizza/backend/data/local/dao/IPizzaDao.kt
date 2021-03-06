package com.tamimattafi.pizza.backend.data.local.dao

import com.tamimattafi.pizza.backend.data.local.entity.PizzaEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface IPizzaDao : CoroutineCrudRepository<PizzaEntity, Int> {
    suspend fun findAll(pageable: Pageable): List<PizzaEntity>
}
