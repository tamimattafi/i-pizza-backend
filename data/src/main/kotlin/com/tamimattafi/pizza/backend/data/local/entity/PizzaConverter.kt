package com.tamimattafi.pizza.backend.data.local.entity

import com.tamimattafi.pizza.backend.domain.model.Pizza

object PizzaConverter {

    fun toPizza(pizzaEntity: PizzaEntity) = pizzaEntity.run {
        Pizza(
            id,
            name,
            description,
            imageUrl,
            price
        )
    }

    fun fromPizza(pizza: Pizza) = pizza.run {
        PizzaEntity(
            id,
            name,
            description,
            imageUrl,
            price
        )
    }
}
