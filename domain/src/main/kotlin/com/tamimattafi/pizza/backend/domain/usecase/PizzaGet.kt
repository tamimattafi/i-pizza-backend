package com.tamimattafi.pizza.backend.domain.usecase

import com.tamimattafi.pizza.backend.domain.repository.IPizzaRepository

class PizzaGet(private val pizzaRepository: IPizzaRepository) {
    suspend operator fun invoke(id: Int) = pizzaRepository.get(id)
}
