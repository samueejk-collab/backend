package etec.bdd.dto

import java.time.LocalDateTime

data class PedidosResponse(
    val id: Int,
    val clienteId: Int,
    val direccionEnvioId: Int,
    val fechaPedido: LocalDateTime,
    val subtotal: Float,
    val costoEnvio: Float,
    val total: Float,
    val estadoEnvio: String,
    val mpStatus: String,
) {
    companion object {
        fun fromEntity(p: Pedidos) = PedidosResponse(
            id = p.id ?: 0,
            clienteId = p.cliente?.idCliente ?: 0,
            direccionEnvioId = p.direccionEnvio?.id ?: 0,
            fechaPedido = p.fechaPedido,
            subtotal = p.subtotal,
            costoEnvio = p.costoEnvio,
            total = p.total,
            estadoEnvio = p.estadoEnvio,
            mpStatus = p.mpStatus,
        )
    }
}