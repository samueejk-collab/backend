package etec.bdd.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoriasRequest(
    @field:NotBlank(message = "El nombre de la categoría no puede estar vacío")
    @field:Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    val nombre: String
)