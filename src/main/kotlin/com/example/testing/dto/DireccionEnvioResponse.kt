package com.example.testing.dto

data class DireccionEnvioResponse(
    val id: Int, val calle: String, val numero: String, val pisoDepto: String?,
    val barrio: String, val ciudad: String, val provincia: String, val codigoPostal: String,
)