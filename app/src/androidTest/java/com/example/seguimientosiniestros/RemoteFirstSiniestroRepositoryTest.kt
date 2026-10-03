package com.example.seguimientosiniestros

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.seguimientosiniestros.data.local.AppDatabase
import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.data.remote.RemoteSiniestroDataSource
import com.example.seguimientosiniestros.data.remote.RetrofitProvider
import com.example.seguimientosiniestros.data.repository.RemoteFirstSiniestroRepository
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RemoteFirstSiniestroRepositoryTest {

    private lateinit var database: AppDatabase
    private lateinit var server: MockWebServer
    private lateinit var repository: RemoteFirstSiniestroRepository

    @Before
    fun preparar() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        server = MockWebServer()
        server.start()

        val local = LocalSiniestroDataSource(
            siniestroDao = database.siniestroDao(),
            gestionHistorialDao = database.gestionHistorialDao()
        )

        val remoto = RemoteSiniestroDataSource(
            apiService = RetrofitProvider.crearSiniestroApi(
                server.url("/api/v1/").toString()
            )
        )

        repository = RemoteFirstSiniestroRepository(
            remoteDataSource = remoto,
            localDataSource = local
        )
    }

    @After
    fun cerrar() {
        database.close()
        server.shutdown()
    }

    @Test
    fun consultaRemotaSeMapeaYQuedaEnCacheRoom() = runBlocking {
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
                        "estadoResultante": "RECIBIDO"
                      }
                    ]
                    """.trimIndent()
                )
        )

        val siniestro = repository.obtenerSiniestro("SIN-2026-001")
        val historial = repository.obtenerHistorial("SIN-2026-001")

        assertNotNull(siniestro)
        assertEquals(EstadoSiniestro.EN_EVALUACION, siniestro?.estado)
        assertEquals(listOf("H-003", "H-001"), historial.map { it.id })

        val cacheSiniestro = database.siniestroDao()
            .obtenerPorId("SIN-2026-001")
        val cacheHistorial = database.gestionHistorialDao()
            .obtenerPorSiniestro("SIN-2026-001")

        assertNotNull(cacheSiniestro)
        assertEquals("EN_EVALUACION", cacheSiniestro?.estado)
        assertEquals(listOf("H-003", "H-001"), cacheHistorial.map { it.id })
    }
}
