package com.example.testing.service

import com.example.testing.dto.DireccionEnvioRequest
import com.example.testing.dto.DireccionEnvioResponse
import com.example.testing.entity.DireccionEnvio
import com.example.testing.exception.RecursoNoEncontradoException
import com.example.testing.repository.DireccionEnvioRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DireccionEnvioService(private val repo: DireccionEnvioRepository) {

    @Transactional(readOnly = true)
    fun listar(pageable: Pageable): Page<DireccionEnvioResponse> =
        repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun obtener(id: Int): DireccionEnvioResponse =
        repo.findById(id)
            .map { it.toResponse() }
            .orElseThrow { RecursoNoEncontradoException("Dirección de envío", id) }

    @Transactional
    fun crear(req: DireccionEnvioRequest): DireccionEnvioResponse =
        repo.save(
            DireccionEnvio(
                calle = req.calle,
                numero = req.numero,
                pisoDepto = req.pisoDepto,
                barrio = req.barrio,
                ciudad = req.ciudad,
                provincia = req.provincia,
                codigoPostal = req.codigoPostal,
            )
        ).toResponse()
}

private fun DireccionEnvio.toResponse() = DireccionEnvioResponse(
    id ?: 0, calle, numero, pisoDepto, barrio, ciudad, provincia, codigoPostal
)