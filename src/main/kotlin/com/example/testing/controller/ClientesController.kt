package com.example.testing.controller

import com.example.testing.dto.ClientesRequest
import com.example.testing.dto.ClientesResponse
import com.example.testing.service.ClientesService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clientes")
class ClientesController(private val service: ClientesService) {

    @GetMapping
    fun listar(pageable: Pageable): Page<ClientesResponse> = service.listar(pageable)

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Int): ClientesResponse = service.obtener(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun crear(@Valid @RequestBody req: ClientesRequest): ClientesResponse = service.crear(req)
}