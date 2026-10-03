package com.example.seguimientosiniestros

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.seguimientosiniestros.data.local.AppDatabase
import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.data.remote.RemoteSiniestroDataSource
import com.example.seguimientosiniestros.data.remote.SiniestroApiService
import com.example.seguimientosiniestros.data.remote.dto.GestionHistorialDto
import com.example.seguimientosiniestros.data.remote.dto.SiniestroDto
import com.example.seguimientosiniestros.data.repository.RemoteFirstSiniestroRepository
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RemoteFirstSiniestroRepositoryTest {

    private lateinit var database: AppDatabase
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

        val apiFalsa = object : SiniestroApiService {
            override suspend fun obtenerSiniestro(id: String) = SiniestroDto(
                id = id,
                tipo = "Accidente vehicular",
                fechaOcurrencia = "2026-09-20",
                fechaReporte = "2026-09-21",
                estado = "EN_EVALUACION",
                equipoAsignado = "Equipo Norte",
                ultimaActualizacion = "2026-09-24T15:30:00"
            )

            override suspend fun obtenerHistorial(id: String) = listOf(
                GestionHistorialDto(
                    id = "H-003",
                    fechaHora = "2026-09-24T15:30:00",
                    descripcion = "Caso asignado a equipo liquidador",
                    estadoResultante = "EN_EVALUACION"
                ),
                GestionHistorialDto(
                    id = "H-001",
                    fechaHora = "2026-09-21T09:10:00",
                    descripcion = "Siniestro recibido",
                    estadoResultante = "RECIBIDO"
                )
            )
        }

        repository = RemoteFirstSiniestroRepository(
            remoteDataSource = RemoteSiniestroDataSource(apiFalsa),
            localDataSource = LocalSiniestroDataSource(
                siniestroDao = database.siniestroDao(),
                gestionHistorialDao = database.gestionHistorialDao()
            )
        )
    }

    @After
    fun cerrar() {
        database.close()
    }

    @Test
    fun respuestaRemotaSeMapeaYQuedaEnCacheRoom() = runBlocking {
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
