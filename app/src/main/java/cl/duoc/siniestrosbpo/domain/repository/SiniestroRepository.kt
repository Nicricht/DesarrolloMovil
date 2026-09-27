package cl.duoc.siniestrosbpo.domain.repository

import cl.duoc.siniestrosbpo.domain.model.GestionHistorial
import cl.duoc.siniestrosbpo.domain.model.Siniestro

interface SiniestroRepository {
    fun buscarPorId(id: String): Siniestro?
    fun obtenerHistorial(siniestroId: String): List<GestionHistorial>
}
