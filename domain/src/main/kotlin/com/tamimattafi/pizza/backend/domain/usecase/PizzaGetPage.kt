package com.tamimattafi.pizza.backend.domain.usecase

import com.tamimattafi.pizza.backend.domain.repository.IPizzaRepository

class PizzaGetPage(private val pizzaRepository: IPizzaRepository) {
    suspend operator fun invoke(pageNumber: Int, pageSize: Int, sortingProperty: String) =
        pizzaRepository.getPage(pageNumber, pageSize, sortingProperty)
}
