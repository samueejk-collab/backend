package com.example.testing.dto

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull

data class PedidosRequest(
    @field:NotNull val clienteId: Int,
    @field:NotNull val direccionEnvioId: Int,
    @field:NotNull @field:DecimalMin("0.0") val subtotal: Float,
    @field:DecimalMin("0.0") val costoEnvio: Float = 0.0f,
)