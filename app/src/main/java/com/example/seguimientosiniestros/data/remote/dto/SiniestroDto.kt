package com.example.seguimientosiniestros.data.remote.dto

data class SiniestroDto(
    val id: String,
    val tipo: String,
    val fechaOcurrencia: String,
    val fechaReporte: String,
    val estado: String,
    val equipoAsignado: String? = null,
    val ultimaActualizacion: String? = null
)
