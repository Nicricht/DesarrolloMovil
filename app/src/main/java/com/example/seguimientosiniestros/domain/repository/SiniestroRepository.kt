package com.example.seguimientosiniestros.domain.repository

import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro

interface SiniestroRepository {
    suspend fun obtenerSiniestro(id: String): Siniestro?
    suspend fun obtenerHistorial(siniestroId: String): List<GestionHistorial>
    suspend fun guardarSiniestro(siniestro: Siniestro)
    suspend fun guardarHistorial(gestiones: List<GestionHistorial>)
}
