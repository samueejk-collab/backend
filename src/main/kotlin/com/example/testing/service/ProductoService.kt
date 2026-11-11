package com.example.testing.service

import com.example.testing.dto.ProductoRequest
import com.example.testing.dto.ProductoResponse
import com.example.testing.entity.Producto
import com.example.testing.exception.ProductoNoEncontradoException
import com.example.testing.exception.RecursoNoEncontradoException
import com.example.testing.repository.CategoriasRepository
import com.example.testing.repository.ProductoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductoService(
    private val productoRepository: ProductoRepository,
    private val categoriasRepository: CategoriasRepository,
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<ProductoResponse> =
        productoRepository.findAll(pageable).map { ProductoResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Long): ProductoResponse =
        productoRepository.findById(id)
            .map { ProductoResponse.fromEntity(it) }
            .orElseThrow { ProductoNoEncontradoException(id) }

    @Transactional
    fun crear(req: ProductoRequest): ProductoResponse {
        req.categoriaId?.let {
            if (!categoriasRepository.existsById(it)) {
                throw RecursoNoEncontradoException("Categoría", it)
            }
        }
        val guardado = productoRepository.save(
            Producto(
                nombre = req.nombre,
                descripcion = req.descripcion,
                precio = req.precio,
                stock = req.stock,
                categoriaId = req.categoriaId,
            )
        )
        return ProductoResponse.fromEntity(guardado)
    }
}