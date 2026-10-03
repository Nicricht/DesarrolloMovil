package com.example.seguimientosiniestros

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.seguimientosiniestros.data.local.AppDatabase
import com.example.seguimientosiniestros.data.local.entity.GestionHistorialEntity
import com.example.seguimientosiniestros.data.local.entity.SiniestroEntity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {

    private lateinit var database: AppDatabase

    @Before
    fun crearBase() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun cerrarBase() {
        database.close()
    }

    @Test
    fun guardaYRecuperaSiniestroConHistorialOrdenado() = runBlocking {
        val siniestro = SiniestroEntity(
            id = "SIN-2026-001",
            tipo = "Caso ficticio",
            fechaOcurrencia = "2026-09-20",
            fechaReporte = "2026-09-21",
            estado = "EN_EVALUACION",
            equipoAsignado = "Equipo de prueba",
            ultimaActualizacion = "2026-09-24T15:30:00"
        )

        database.siniestroDao().guardar(siniestro)

        val recuperado = database.siniestroDao().obtenerPorId("SIN-2026-001")
        assertNotNull(recuperado)
        assertEquals(siniestro, recuperado)

        database.gestionHistorialDao().guardarTodos(
            listOf(
                GestionHistorialEntity(
                    id = "G-1",
                    siniestroId = siniestro.id,
                    fechaHora = "2026-09-21T09:10:00",
                    descripcion = "Siniestro registrado",
                    estadoResultante = "RECIBIDO"
                ),
                GestionHistorialEntity(
                    id = "G-3",
                    siniestroId = siniestro.id,
                    fechaHora = "2026-09-24T15:30:00",
                    descripcion = "Caso asignado",
                    estadoResultante = "EN_EVALUACION"
                ),
                GestionHistorialEntity(
                    id = "G-2",
                    siniestroId = siniestro.id,
                    fechaHora = "2026-09-22T10:00:00",
                    descripcion = "Documentación recibida",
                    estadoResultante = null
                )
            )
        )

        val historial = database.gestionHistorialDao()
            .obtenerPorSiniestro("SIN-2026-001")

        assertEquals(listOf("G-3", "G-2", "G-1"), historial.map { it.id })
    }
}
