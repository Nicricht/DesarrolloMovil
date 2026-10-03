package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.data.remote.RetrofitProvider
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class RetrofitContractTest {

    private lateinit var server: MockWebServer

    @Before
    fun iniciarServidor() {
        server = MockWebServer()
        server.start()
    }

    @After
    fun cerrarServidor() {
        server.shutdown()
    }

    @Test
    fun consultaSiniestroUsaRutaYParseaContrato() = runBlocking {
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(
                    """
                    {
                      "id": "SIN-2026-001",
                      "tipo": "Accidente vehicular",
                      "fechaOcurrencia": "2026-09-20",
                      "fechaReporte": "2026-09-21",
                      "estado": "EN_EVALUACION",
                      "equipoAsignado": "Equipo Norte",
                      "ultimaActualizacion": "2026-09-24T15:30:00"
                    }
                    """.trimIndent()
                )
        )

        val api = RetrofitProvider.crearSiniestroApi(
            server.url("/api/v1/").toString()
        )

        val dto = api.obtenerSiniestro("SIN-2026-001")
        val request = server.takeRequest()

        assertEquals("/api/v1/siniestros/SIN-2026-001", request.path)
        assertEquals("SIN-2026-001", dto.id)
        assertEquals("EN_EVALUACION", dto.estado)
        assertEquals("Equipo Norte", dto.equipoAsignado)
    }

    @Test
    fun consultaHistorialUsaRutaYParseaLista() = runBlocking {
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(
                    """
                    [
                      {
                        "id": "H-003",
                        "fechaHora": "2026-09-24T15:30:00",
                        "descripcion": "Caso asignado a equipo liquidador",
                        "estadoResultante": "EN_EVALUACION"
                      },
                      {
                        "id": "H-001",
                        "fechaHora": "2026-09-21T09:10:00",
                        "descripcion": "Siniestro recibido",
                        "estadoResultante": null
                      }
                    ]
                    """.trimIndent()
                )
        )

        val api = RetrofitProvider.crearSiniestroApi(
            server.url("/api/v1/").toString()
        )

        val historial = api.obtenerHistorial("SIN-2026-001")
        val request = server.takeRequest()

        assertEquals("/api/v1/siniestros/SIN-2026-001/historial", request.path)
        assertEquals(2, historial.size)
        assertEquals("H-003", historial.first().id)
        assertNull(historial.last().estadoResultante)
    }
}
