package com.example.seguimientosiniestros

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.seguimientosiniestros.data.local.AppDatabase
import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.data.repository.LocalSiniestroRepository
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocalSiniestroRepositoryTest {

    private lateinit var database: AppDatabase
    private lateinit var repository: LocalSiniestroRepository

    @Before
    fun preparar() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        repository = LocalSiniestroRepository(
            LocalSiniestroDataSource(
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
    fun guardaYRecuperaDatosDesdeRepository() = runBlocking {
        val siniestro = Siniestro(
            id = "SIN-2026-001",
            tipo = "Caso ficticio",
            fechaOcurrencia = "2026-09-20",
            fechaReporte = "2026-09-21",
            estado = EstadoSiniestro.EN_EVALUACION,
            equipoAsignado = "Equipo de prueba"
        )

        val historial = listOf(
            GestionHistorial(
                id = "R-1",
                siniestroId = siniestro.id,
                fechaHora = "2026-09-21T09:00:00",
                descripcion = "Registro inicial",
                estadoResultante = EstadoSiniestro.RECIBIDO
            ),
            GestionHistorial(
                id = "R-2",
                siniestroId = siniestro.id,
                fechaHora = "2026-09-22T10:00:00",
                descripcion = "Revisión",
                estadoResultante = EstadoSiniestro.EN_EVALUACION
            )
        )

        repository.guardarSiniestro(siniestro)
        repository.guardarHistorial(historial)

        val recuperado = repository.obtenerSiniestro(siniestro.id)
        val historialRecuperado = repository.obtenerHistorial(siniestro.id)

        assertNotNull(recuperado)
        assertEquals(siniestro, recuperado)
        assertEquals(listOf("R-2", "R-1"), historialRecuperado.map { it.id })
    }
}
