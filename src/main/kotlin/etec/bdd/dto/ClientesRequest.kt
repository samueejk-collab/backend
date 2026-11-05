package etec.bdd.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ClientesRequest(
    @field:NotBlank @field:Size(max = 100) val nombreCliente: String,
    @field:NotBlank @field:Size(max = 100) val telefono: String,
    @field:NotBlank @field:Email @field:Size(max = 100) val correo: String,
    @field:NotBlank @field:Size(max = 100) val fecha: String,
)