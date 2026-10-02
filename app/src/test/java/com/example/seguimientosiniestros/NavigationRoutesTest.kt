package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.navigation.Destino
import org.junit.Assert.assertEquals
import org.junit.Test

class NavigationRoutesTest {

    @Test
    fun rutasConservanElIdentificadorDelSiniestro() {
        val id = "SIN-2026-001"

        assertEquals("detalle/$id", Destino.detalle(id))
        assertEquals("seguimiento/$id", Destino.seguimiento(id))
        assertEquals("historial/$id", Destino.historial(id))
        assertEquals("evidencias/$id", Destino.evidencias(id))
    }
}
