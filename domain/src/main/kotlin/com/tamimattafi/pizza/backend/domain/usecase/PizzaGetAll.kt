package com.tamimattafi.pizza.backend.domain.usecase

import com.tamimattafi.pizza.backend.domain.repository.IPizzaRepository

class PizzaGetAll(private val pizzaRepository: IPizzaRepository) {
    suspend operator fun invoke() = pizzaRepository.getAll()
}
