package etec.bdd.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ClientesRequest(
    @field:NotBlank(message = "El nombre es obligatorio")
    @field:Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    val nombre: String,

    @field:NotBlank(message = "El email es obligatorio")
    @field:Email(message = "Debe ser un formato de correo electrónico válido")
    val email: String,

    @field:Size(max = 20, message = "El teléfono no puede superar los 20 caracteres")
    val telefono: String?
)