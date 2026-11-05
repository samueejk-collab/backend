package etec.bdd.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class PedidosRequest(
    @field:NotNull val clienteId: Int,
    @field:NotNull val direccionEnvioId: Int,
    @field:NotNull @field:DecimalMin("0.0") val subtotal: Float,
    @field:DecimalMin("0.0") val costoEnvio: Float = 0.0f,
)