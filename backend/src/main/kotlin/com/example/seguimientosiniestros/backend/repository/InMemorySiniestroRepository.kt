package com.example.seguimientosiniestros.backend.repository

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse
import org.springframework.stereotype.Repository

@Repository
class InMemorySiniestroRepository : SiniestroRepository {

    private val siniestros = mapOf(
        DEMO_ID to SiniestroResponse(
            id = DEMO_ID,
            tipo = "Accidente vehicular",
            fechaOcurrencia = "2026-09-20",
            fechaReporte = "2026-09-21",
            estado = "EN_EVALUACION",
            equipoAsignado = "Equipo Norte",
            ultimaActualizacion = "2026-09-24T15:30:00"
        )
    )

    private val historial = mapOf(
        DEMO_ID to listOf(
            GestionHistorialResponse("H-001", "2026-09-21T09:10:00", "Siniestro recibido", "RECIBIDO"),
            GestionHistorialResponse("H-002", "2026-09-22T10:00:00", "Documentación recibida", null),
            GestionHistorialResponse("H-003", "2026-09-24T15:30:00", "Caso asignado a equipo liquidador", "EN_EVALUACION")
        )
    )

    override fun findById(id: String): SiniestroResponse? = siniestros[id]

    override fun findHistorialBySiniestroId(siniestroId: String): List<GestionHistorialResponse> =
        historial[siniestroId].orEmpty().sortedByDescending { it.fechaHora }

    companion object {
        private const val DEMO_ID = "SIN-2026-001"
    }
}
