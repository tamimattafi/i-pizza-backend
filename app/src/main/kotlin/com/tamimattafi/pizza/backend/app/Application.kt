package com.tamimattafi.pizza.backend.app

import com.tamimattafi.pizza.backend.presentation.controllers.PizzaController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories
class Application

fun main(args: Array<String>) {
		runApplication<Application>(*args)
}
