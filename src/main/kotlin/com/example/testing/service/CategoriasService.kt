package com.example.testing.service

import com.example.testing.dto.CategoriasRequest
import com.example.testing.dto.CategoriasResponse
import com.example.testing.entity.Categorias
import com.example.testing.exception.RecursoNoEncontradoException
import com.example.testing.repository.CategoriasRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoriasService(private val repo: CategoriasRepository) {

    @Transactional(readOnly = true)
    fun listar(): List<CategoriasResponse> = repo.findAll().map { it.toResponse() }

    @Transactional(readOnly = true)
    fun obtener(id: Int): CategoriasResponse =
        repo.findById(id)
            .map { it.toResponse() }
            .orElseThrow { RecursoNoEncontradoException("Categoría", id) }

    @Transactional
    fun crear(req: CategoriasRequest): CategoriasResponse =
        repo.save(Categorias(nombre = req.nombre, descripcion = req.descripcion)).toResponse()
}

private fun Categorias.toResponse() = CategoriasResponse(id ?: 0, nombre, descripcion)