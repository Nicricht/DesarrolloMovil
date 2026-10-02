package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import org.junit.Assert.assertEquals
import org.junit.Test

class DomainModelsTest {

    @Test
    fun estadosDeSiniestroCoincidenConElCaso() {
        assertEquals(
            listOf(
                "RECIBIDO",
                "EN_EVALUACION",
                "EN_LIQUIDACION",
                "CERRADO"
            ),
            EstadoSiniestro.entries.map { it.name }
        )
    }
}
