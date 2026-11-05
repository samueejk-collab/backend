package com.example.testing.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoriasRequest(
    @field:NotBlank @field:Size(max = 50) val nombre: String,
    @field:Size(max = 255) val descripcion: String? = null,
)