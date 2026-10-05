package com.example.seguimientosiniestros.backend.service

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse
import com.example.seguimientosiniestros.backend.repository.SiniestroRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SiniestroService(
    private val repository: SiniestroRepository
) {
    fun obtenerSiniestro(id: String): SiniestroResponse =
        repository.findById(id)
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No existe un siniestro con el identificador indicado"
            )

    fun obtenerHistorial(id: String): List<GestionHistorialResponse> {
        obtenerSiniestro(id)
        return repository.findHistorialBySiniestroId(id)
    }
}
