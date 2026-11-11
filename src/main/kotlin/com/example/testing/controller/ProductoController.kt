package com.example.testing.controller

import com.example.testing.dto.ProductoRequest
import com.example.testing.dto.ProductoResponse
import com.example.testing.service.ProductoService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = ["http://localhost:3000"])
class ProductoController(private val service: ProductoService) {

    @GetMapping
    fun listar(pageable: Pageable): Page<ProductoResponse> = service.listar(pageable)

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Long): ProductoResponse = service.obtener(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun crear(@Valid @RequestBody req: ProductoRequest): ProductoResponse = service.crear(req)
}