package etec.bdd.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class DireccionEnvioRequest(
    @field:NotNull(message = "El ID del cliente es obligatorio")
    val clienteId: Long,

    @field:NotBlank(message = "La calle es obligatoria")
    @field:Size(max = 150, message = "La calle no puede superar los 150 caracteres")
    val calle: String,

    @field:NotBlank(message = "La ciudad es obligatoria")
    @field:Size(max = 100, message = "La ciudad no puede superar los 100 caracteres")
    val ciudad: String,

    @field:NotBlank(message = "El código postal es obligatorio")
    @field:Size(max = 20, message = "El código postal no puede superar los 20 caracteres")
    val codigoPostal: String
)