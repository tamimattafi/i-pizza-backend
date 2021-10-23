package com.tamimattafi.pizza.backend.domain.repository

import com.tamimattafi.pizza.backend.domain.model.Pizza

interface IPizzaRepository {
    suspend fun getAll(): List<Pizza>
    suspend fun get(id: Int): Pizza
}
