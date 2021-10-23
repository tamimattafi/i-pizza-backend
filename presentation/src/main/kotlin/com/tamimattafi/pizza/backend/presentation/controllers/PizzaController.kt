package com.tamimattafi.pizza.backend.presentation.controllers

import com.tamimattafi.pizza.backend.domain.model.Pizza
import com.tamimattafi.pizza.backend.domain.usecase.PizzaGet
import com.tamimattafi.pizza.backend.domain.usecase.PizzaGetPage
import com.tamimattafi.pizza.backend.presentation.defaults.Pagination.DEFAULT_PAGE_NUMBER_PARAMETER
import com.tamimattafi.pizza.backend.presentation.defaults.Pagination.DEFAULT_PAGE_SIZE_PARAMETER
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PizzaController(
    private val getPizzaPage: PizzaGetPage,
    private val getPizza: PizzaGet
) {

    @GetMapping("/pizza")
    suspend fun getPizzasPage(
        @RequestParam(DEFAULT_PAGE_NUMBER_PARAMETER) pageNumber: Int,
        @RequestParam(DEFAULT_PAGE_SIZE_PARAMETER) pageSize: Int,
        @RequestParam(Pizza.ID_FIELD) sortProperty: String
    ): ResponseEntity<List<Pizza>> {
        val pizzas = getPizzaPage(
            pageNumber,
            pageSize,
            sortProperty
        )

        return ResponseEntity.ok(pizzas)
    }

    @GetMapping("/pizza/{id}")
    suspend fun getPizzaById(
        @PathVariable("id") pizzaId: Int
    ): ResponseEntity<Pizza> {
        val pizza = getPizza(pizzaId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pizza)
    }
}