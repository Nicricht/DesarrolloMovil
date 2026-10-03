package com.example.seguimientosiniestros.data.demo

import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro

object DatosDemo {

    const val SINIESTRO_ID = "SIN-2026-001"

    val siniestro = Siniestro(
        id = SINIESTRO_ID,
        tipo = "Accidente vehicular",
        fechaOcurrencia = "2026-09-20",
        fechaReporte = "2026-09-21",
        estado = EstadoSiniestro.EN_EVALUACION,
        equipoAsignado = "Equipo Norte",
        ultimaActualizacion = "2026-09-24T15:30:00"
    )

    val historial = listOf(
        GestionHistorial(
            id = "GEST-001",
            siniestroId = SINIESTRO_ID,
            fechaHora = "2026-09-21T09:10:00",
            descripcion = "Siniestro registrado",
            estadoResultante = EstadoSiniestro.RECIBIDO
        ),
        GestionHistorial(
            id = "GEST-002",
            siniestroId = SINIESTRO_ID,
            fechaHora = "2026-09-22T10:00:00",
            descripcion = "Documentación recibida"
        ),
        GestionHistorial(
            id = "GEST-003",
            siniestroId = SINIESTRO_ID,
            fechaHora = "2026-09-24T15:30:00",
            descripcion = "Caso asignado a liquidador",
            estadoResultante = EstadoSiniestro.EN_EVALUACION
        )
    )
}
