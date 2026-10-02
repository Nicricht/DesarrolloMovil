package com.example.seguimientosiniestros.domain.model

data class GestionHistorial(
    val id: String,
    val siniestroId: String,
    val fechaHora: String,
    val descripcion: String,
    val estadoResultante: EstadoSiniestro? = null
)
