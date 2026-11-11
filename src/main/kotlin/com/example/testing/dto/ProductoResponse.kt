package com.example.testing.dto

import com.example.testing.entity.Producto
import tools.jackson.databind.annotation.JsonSerialize
import tools.jackson.databind.ser.std.ToStringSerializer
import java.math.BigDecimal

data class StockPorTalleDto(
    val talle: String,
    val stock: Int
)

data class ProductoResponse(
    val id: Long,
    val nombre: String,
    val descripcion: String?,
    val categoria: String,

    @JsonSerialize(using = ToStringSerializer::class)
    val precioMayorista: BigDecimal,

    val imagenes: List<String>,
    val unidadMinimaPorPedido: Int,
    val activo: Boolean,
    val tallesDisponibles: List<StockPorTalleDto>
) {
    companion object {
        fun fromEntity(p: Producto): ProductoResponse {
            val stockTotal = p.stock ?: 0

            // Distribuimos el stock de MySQL entre los talles 2, 4 y 6
            val talle2 = stockTotal / 3
            val talle4 = stockTotal / 3
            val talle6 = stockTotal - (talle2 + talle4)

            // Mapeamos el categoriaId a un nombre de categoría y su imagen correspondiente
            val nombreCategoria = when (p.categoriaId) {
                2 -> "conjuntos"
                3 -> "pantalones"
                else -> "camperas"
            }

            val imagenUrl = when (nombreCategoria) {
                "conjuntos" -> "/products/conjunto-training.png"
                "pantalones" -> "/products/pantalon-jogger.png"
                else -> "/products/campera-pro.png"
            }

            return ProductoResponse(
                id = p.id ?: 0L,
                nombre = p.nombre,
                descripcion = p.descripcion ?: "",
                categoria = nombreCategoria,
                precioMayorista = p.precio,
                imagenes = listOf(imagenUrl),
                unidadMinimaPorPedido = 6,
                activo = true,
                tallesDisponibles = listOf(
                    StockPorTalleDto("2", talle2),
                    StockPorTalleDto("4", talle4),
                    StockPorTalleDto("6", talle6)
                )
            )
        }
    }
}