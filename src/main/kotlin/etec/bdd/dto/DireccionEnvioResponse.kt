package etec.bdd.dto

data class DireccionEnvioResponse(
    val id: Long,
    val clienteId: Long,
    val calle: String,
    val ciudad: String,
    val codigoPostal: String
)