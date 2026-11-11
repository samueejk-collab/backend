package com.example.testing.controller

import com.example.testing.dto.PedidosRequest
import com.example.testing.dto.PedidosResponse
import com.example.testing.service.PedidosService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pedidos")
class PedidosController(private val service: PedidosService) {

    @GetMapping
    fun listar(pageable: Pageable): Page<PedidosResponse> = service.listar(pageable)

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Int): PedidosResponse = service.obtener(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun crear(@Valid @RequestBody req: PedidosRequest): PedidosResponse = service.crear(req)
}