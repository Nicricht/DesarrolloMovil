package com.example.seguimientosiniestros.backend.dto

data class SiniestroResponse(
    val id: String,
    val tipo: String,
    val fechaOcurrencia: String,
    val fechaReporte: String,
    val estado: String,
    val equipoAsignado: String,
    val ultimaActualizacion: String
)
