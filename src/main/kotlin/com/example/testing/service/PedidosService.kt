package com.example.testing.service

import com.example.testing.dto.PedidosRequest
import com.example.testing.dto.PedidosResponse
import com.example.testing.entity.Pedidos
import com.example.testing.exception.RecursoNoEncontradoException
import com.example.testing.repository.ClientesRepository
import com.example.testing.repository.DireccionEnvioRepository
import com.example.testing.repository.PedidosRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PedidosService(
    private val pedidosRepository: PedidosRepository,
    private val clientesRepository: ClientesRepository,
    private val direccionEnvioRepository: DireccionEnvioRepository,
) {
    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<PedidosResponse> =
        pedidosRepository.findAll(pageable).map { PedidosResponse.fromEntity(it) }

    @Transactional(readOnly = true)
    fun obtener(id: Int): PedidosResponse =
        pedidosRepository.findById(id)
            .map { PedidosResponse.fromEntity(it) }
            .orElseThrow { RecursoNoEncontradoException("Pedido", id) }

    @Transactional
    fun crear(req: PedidosRequest): PedidosResponse {
        val cliente = clientesRepository.findById(req.clienteId)
            .orElseThrow { RecursoNoEncontradoException("Cliente", req.clienteId) }
        val direccion = direccionEnvioRepository.findById(req.direccionEnvioId)
            .orElseThrow { RecursoNoEncontradoException("Dirección de envío", req.direccionEnvioId) }

        val pedido = Pedidos(
            cliente = cliente,
            direccionEnvio = direccion,
            subtotal = req.subtotal,
            costoEnvio = req.costoEnvio,
            total = req.subtotal + req.costoEnvio,
        )
        return PedidosResponse.fromEntity(pedidosRepository.save(pedido))
    }
}