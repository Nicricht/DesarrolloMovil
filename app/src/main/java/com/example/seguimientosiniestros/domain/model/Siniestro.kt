package com.example.seguimientosiniestros.domain.model

data class Siniestro(
    val id: String,
    val tipo: String,
    val fechaOcurrencia: String,
    val fechaReporte: String,
    val estado: EstadoSiniestro,
    val equipoAsignado: String? = null,
    val ultimaActualizacion: String? = null
)
