package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.data.mapper.toDomain
import com.example.seguimientosiniestros.data.mapper.toEntity
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro
import org.junit.Assert.assertEquals
import org.junit.Test

class RoomMappersTest {

    @Test
    fun siniestroConservaSusDatosAlPasarPorEntity() {
        val original = Siniestro(
            id = "SIN-TEST-001",
            tipo = "Caso ficticio",
            fechaOcurrencia = "2026-10-01",
            fechaReporte = "2026-10-02",
            estado = EstadoSiniestro.EN_EVALUACION,
            equipoAsignado = "Equipo prueba",
            ultimaActualizacion = "2026-10-02T12:00:00"
        )

        assertEquals(original, original.toEntity().toDomain())
    }

    @Test
    fun gestionConservaSusDatosAlPasarPorEntity() {
        val original = GestionHistorial(
            id = "GEST-TEST-001",
            siniestroId = "SIN-TEST-001",
            fechaHora = "2026-10-02T12:30:00",
            descripcion = "Gestión ficticia",
            estadoResultante = EstadoSiniestro.EN_LIQUIDACION
        )

        assertEquals(original, original.toEntity().toDomain())
    }
}
