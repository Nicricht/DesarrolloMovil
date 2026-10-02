package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import org.junit.Assert.assertEquals
import org.junit.Test

class EstadoSiniestroPresentacionTest {

    @Test
    fun estadosMantienenOrdenDelProceso() {
        assertEquals(
            listOf(
                EstadoSiniestro.RECIBIDO,
                EstadoSiniestro.EN_EVALUACION,
                EstadoSiniestro.EN_LIQUIDACION,
                EstadoSiniestro.CERRADO
            ),
            EstadoSiniestro.entries
        )
    }
}
