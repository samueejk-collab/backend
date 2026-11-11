package com.example.testing.service

import com.example.testing.dto.ClientesRequest
import com.example.testing.dto.ClientesResponse
import com.example.testing.entity.Clientes
import com.example.testing.exception.RecursoNoEncontradoException
import com.example.testing.repository.ClientesRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClientesService(private val repo: ClientesRepository) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<ClientesResponse> =
        repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun obtener(id: Int): ClientesResponse =
        repo.findById(id)
            .map { it.toResponse() }
            .orElseThrow { RecursoNoEncontradoException("Cliente", id) }

    @Transactional
    fun crear(req: ClientesRequest): ClientesResponse =
        repo.save(
            Clientes(
                nombreCliente = req.nombreCliente,
                telefono = req.telefono,
                correo = req.correo,
                fecha = req.fecha,
            )
        ).toResponse()
}

private fun Clientes.toResponse() =
    ClientesResponse(idCliente ?: 0, nombreCliente, telefono, correo, fecha)