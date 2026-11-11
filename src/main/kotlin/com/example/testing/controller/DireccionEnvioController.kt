package com.example.testing.controller

import com.example.testing.dto.DireccionEnvioRequest
import com.example.testing.dto.DireccionEnvioResponse
import com.example.testing.service.DireccionEnvioService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/direcciones")
class DireccionEnvioController(private val service: DireccionEnvioService) {

    @GetMapping
    fun listar(pageable: Pageable): Page<DireccionEnvioResponse> = service.listar(pageable)

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Int): DireccionEnvioResponse = service.obtener(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun crear(@Valid @RequestBody req: DireccionEnvioRequest): DireccionEnvioResponse = service.crear(req)
}