package com.example.seguimientosiniestros.data.remote

import com.example.seguimientosiniestros.data.remote.dto.GestionHistorialDto
import com.example.seguimientosiniestros.data.remote.dto.SiniestroDto

class RemoteSiniestroDataSource(
    private val apiService: SiniestroApiService
) {
    suspend fun obtenerSiniestro(id: String): SiniestroDto =
        apiService.obtenerSiniestro(id)

    suspend fun obtenerHistorial(siniestroId: String): List<GestionHistorialDto> =
        apiService.obtenerHistorial(siniestroId)
}
