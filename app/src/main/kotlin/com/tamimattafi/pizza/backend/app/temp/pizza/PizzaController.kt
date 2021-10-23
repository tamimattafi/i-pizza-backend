package com.tamimattafi.pizza.backend.app.temp.pizza

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/pizza")
@RestController
class PizzaController @Autowired constructor() {

    @GetMapping
    fun getAll(): ResponseEntity<List<PizzaEntity>> {
        return ResponseEntity.ok(PizzaDatabase.pizzaDao.getAll())
    }

    @GetMapping("{id}")
    fun getById(@PathVariable("id") id: Int): ResponseEntity<PizzaEntity> {
        val pizza = PizzaDatabase.pizzaDao.getById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pizza)
    }

    @PostMapping("/order")
    fun sendOrder(@RequestBody orders: List<PizzaOrder>): ResponseEntity<Unit> {
        if (orders.isEmpty()) return ResponseEntity.badRequest().build()
        return ResponseEntity.ok().build()
    }
}


