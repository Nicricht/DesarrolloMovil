package com.example.seguimientosiniestros.data.remote.dto

data class GestionHistorialDto(
    val id: String,
    val fechaHora: String,
    val descripcion: String,
    val estadoResultante: String? = null
)
