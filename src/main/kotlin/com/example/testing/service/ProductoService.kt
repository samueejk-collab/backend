package com.example.testing.service

import com.example.testing.dto.ProductoResponse

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
            if (!categoriasRepository.existsById(it))RecursoNoEncontradoException("Categoría", it)
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