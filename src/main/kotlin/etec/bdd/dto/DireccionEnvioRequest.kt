package etec.bdd.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class DireccionEnvioRequest(
    @field:NotBlank @field:Size(max = 100) val calle: String,
    @field:NotBlank @field:Size(max = 20) val numero: String,
    @field:Size(max = 20) val pisoDepto: String? = null,
    @field:NotBlank @field:Size(max = 100) val barrio: String,
    @field:NotBlank @field:Size(max = 50) val ciudad: String,
    @field:NotBlank @field:Size(max = 50) val provincia: String,
    @field:NotBlank @field:Size(max = 20) val codigoPostal: String,
)