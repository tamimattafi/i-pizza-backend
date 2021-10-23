package com.tamimattafi.pizza.backend.domain.model

data class Pizza(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val price: Double
)
