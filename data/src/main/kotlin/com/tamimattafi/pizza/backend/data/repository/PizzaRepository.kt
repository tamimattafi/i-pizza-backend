package com.tamimattafi.pizza.backend.data.repository

import com.tamimattafi.pizza.backend.data.local.dao.IPizzaDao
import com.tamimattafi.pizza.backend.data.local.entity.PizzaConverter
import com.tamimattafi.pizza.backend.domain.model.Pizza
import com.tamimattafi.pizza.backend.domain.repository.IPizzaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository

@Repository
class PizzaRepository @Autowired constructor(
    private val pizzaDao: IPizzaDao
) : IPizzaRepository {

    override suspend fun getPage(
        pageNumber: Int,
        pageSize: Int,
        sortingProperty: String
    ): List<Pizza> {
        val sorting = Sort.by(sortingProperty)
        val pageable = PageRequest.of(
            pageNumber,
            pageSize,
            sorting
        )

        return pizzaDao.findAll(pageable)
            .map(PizzaConverter::toPizza)
    }

    override suspend fun get(id: Int): Pizza?
        = pizzaDao.findById(id)?.let(PizzaConverter::toPizza)
}
