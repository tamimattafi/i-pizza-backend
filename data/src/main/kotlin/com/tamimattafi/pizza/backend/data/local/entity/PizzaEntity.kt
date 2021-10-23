package com.tamimattafi.pizza.backend.data.local.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("pizza")
data class PizzaEntity(
    @Id val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val price: Double
)
