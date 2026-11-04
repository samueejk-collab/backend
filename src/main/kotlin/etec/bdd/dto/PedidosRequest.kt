package etec.bdd.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class PedidosRequest(
    @field:NotNull(message = "El ID del cliente es obligatorio")
    val clienteId: Long,

    @field:NotNull(message = "El ID de la dirección de envío es obligatorio")
    val direccionEnvioId: Long,

    @field:NotEmpty(message = "El pedido debe contener al menos un detalle de producto")
    @field:Valid // Fuerza a validar también los objetos internos de la lista
    val detalles: List<DetallePedidoRequest>
)