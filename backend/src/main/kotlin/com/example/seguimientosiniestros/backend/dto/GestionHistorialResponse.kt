package com.example.seguimientosiniestros.backend.dto

data class GestionHistorialResponse(
    val id: String,
    val fechaHora: String,
    val descripcion: String,
    val estadoResultante: String?
)
