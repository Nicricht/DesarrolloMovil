package com.example.seguimientosiniestros.backend.repository

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse

interface SiniestroRepository {
    fun findById(id: String): SiniestroResponse?
    fun findHistorialBySiniestroId(siniestroId: String): List<GestionHistorialResponse>
}
