package com.example.testing.controller

import com.example.testing.dto.CategoriasRequest
import com.example.testing.dto.CategoriasResponse
import com.example.testing.service.CategoriasService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categorias")
class CategoriasController(private val service: CategoriasService) {

    @GetMapping
    fun listar(): List<CategoriasResponse> = service.listar()

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Int): CategoriasResponse = service.obtener(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun crear(@Valid @RequestBody req: CategoriasRequest): CategoriasResponse = service.crear(req)
}