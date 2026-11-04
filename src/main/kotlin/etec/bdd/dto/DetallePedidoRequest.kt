package etec.bdd.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class DetallePedidoRequest(
    @field:NotNull(message = "El ID de la variante/producto es obligatorio")
    val varianteId: Int,

    @field:NotNull(message = "La cantidad es obligatoria")
    @field:Min(value = 1, message = "La cantidad mínima debe ser al menos 1")
    val cantidad: Int
)