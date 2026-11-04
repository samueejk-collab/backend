package etec.bdd.dto

data class DetallePedidoResponse(
    val id: Long,
    val varianteId: Int,
    val cantidad: Int,
    val precioHistorico: Float
)