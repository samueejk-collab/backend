package etec.bdd.dto

data class ClientesResponse(
    val id: Long,
    val nombre: String,
    val email: String,
    val telefono: String?
)