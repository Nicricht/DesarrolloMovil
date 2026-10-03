package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.data.mapper.toDomain
import com.example.seguimientosiniestros.data.remote.dto.GestionHistorialDto
import com.example.seguimientosiniestros.data.remote.dto.SiniestroDto
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import org.junit.Assert.assertEquals
import org.junit.Test

class RemoteMappersTest {

    @Test
    fun siniestroDtoSeConvierteADominio() {
        val dto = SiniestroDto(
            id = "SIN-2026-001",
            tipo = "Accidente vehicular",
            fechaOcurrencia = "2026-09-20",
            fechaReporte = "2026-09-21",
            estado = "EN_EVALUACION",
            equipoAsignado = "Equipo Norte",
            ultimaActualizacion = "2026-09-24T15:30:00"
        )

        val dominio = dto.toDomain()

        assertEquals("SIN-2026-001", dominio.id)
        assertEquals(EstadoSiniestro.EN_EVALUACION, dominio.estado)
        assertEquals("Equipo Norte", dominio.equipoAsignado)
    }

    @Test
    fun gestionDtoRecibeIdDelSiniestro() {
        val dto = GestionHistorialDto(
            id = "H-001",
            fechaHora = "2026-09-21T09:10:00",
            descripcion = "Siniestro recibido",
            estadoResultante = "RECIBIDO"
        )

        val dominio = dto.toDomain("SIN-2026-001")

        assertEquals("SIN-2026-001", dominio.siniestroId)
        assertEquals(EstadoSiniestro.RECIBIDO, dominio.estadoResultante)
    }
}
