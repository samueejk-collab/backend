package etec.bdd.dto

import java.time.LocalDateTime

data class PedidosResponse(
    val id: Long,
    val clienteId: Long,
    val direccionEnvioId: Long,
    val fecha: LocalDateTime,
    val estado: String,
    val detalles: List<DetallePedidoResponse>
)