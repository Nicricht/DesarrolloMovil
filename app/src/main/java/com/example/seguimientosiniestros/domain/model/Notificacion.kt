package com.example.seguimientosiniestros.domain.model

data class Notificacion(
    val id: String,
    val siniestroId: String,
    val titulo: String,
    val mensaje: String,
    val fechaHora: String,
    val leida: Boolean = false
)
