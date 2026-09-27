package cl.duoc.siniestrosbpo.data.repository

import cl.duoc.siniestrosbpo.domain.model.EstadoSiniestro
import cl.duoc.siniestrosbpo.domain.model.GestionHistorial
import cl.duoc.siniestrosbpo.domain.model.Siniestro
import cl.duoc.siniestrosbpo.domain.repository.SiniestroRepository

class FakeSiniestroRepository : SiniestroRepository {

    private val siniestros = listOf(
        Siniestro(
            id = "SIN-2026-001",
            tipo = "Daño vehicular",
            fechaOcurrencia = "20-09-2026",
            fechaReporte = "21-09-2026",
            estado = EstadoSiniestro.EN_EVALUACION,
            equipoAsignado = "Equipo de liquidación Norte",
            ultimaActualizacion = "23-09-2026 10:15"
        )
    )

    private val historial = listOf(
        GestionHistorial(
            id = "GES-001",
            siniestroId = "SIN-2026-001",
            fechaHora = "21-09-2026 09:10",
            descripcion = "Siniestro recibido por el sistema.",
            estadoResultante = EstadoSiniestro.RECIBIDO
        ),
        GestionHistorial(
            id = "GES-002",
            siniestroId = "SIN-2026-001",
            fechaHora = "22-09-2026 11:40",
            descripcion = "Antecedentes iniciales revisados.",
            estadoResultante = EstadoSiniestro.EN_EVALUACION
        ),
        GestionHistorial(
            id = "GES-003",
            siniestroId = "SIN-2026-001",
            fechaHora = "23-09-2026 10:15",
            descripcion = "Caso asignado al equipo de liquidación Norte.",
            estadoResultante = EstadoSiniestro.EN_EVALUACION
        )
    )

    override fun buscarPorId(id: String): Siniestro? {
        return siniestros.firstOrNull { it.id.equals(id.trim(), ignoreCase = true) }
    }

    override fun obtenerHistorial(siniestroId: String): List<GestionHistorial> {
        return historial.filter { it.siniestroId.equals(siniestroId, ignoreCase = true) }
    }
}
