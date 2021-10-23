package com.tamimattafi.pizza.backend.data.repository

import com.tamimattafi.pizza.backend.data.local.dao.IPizzaDao
import com.tamimattafi.pizza.backend.data.local.entity.PizzaConverter
import com.tamimattafi.pizza.backend.domain.model.Pizza
import com.tamimattafi.pizza.backend.domain.repository.IPizzaRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

class PizzaRepository(
    private val pizzaDao: IPizzaDao
) : IPizzaRepository {

    override suspend fun getAll(): List<Pizza>
        = pizzaDao.findAll()
            .map(PizzaConverter::toPizza)
            .toList()

    override suspend fun get(id: Int): Pizza?
        = pizzaDao.findById(id)?.let(PizzaConverter::toPizza)
}
