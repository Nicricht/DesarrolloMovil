package com.example.seguimientosiniestros.data.remote

import com.example.seguimientosiniestros.data.remote.dto.GestionHistorialDto
import com.example.seguimientosiniestros.data.remote.dto.SiniestroDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SiniestroApiService {

    @GET("siniestros/{id}")
    suspend fun obtenerSiniestro(
        @Path("id") id: String
    ): SiniestroDto

    @GET("siniestros/{id}/historial")
    suspend fun obtenerHistorial(
        @Path("id") id: String
    ): List<GestionHistorialDto>
}
