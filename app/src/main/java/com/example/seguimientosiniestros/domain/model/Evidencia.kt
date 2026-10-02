package com.example.seguimientosiniestros.domain.model

data class Evidencia(
    val id: String,
    val siniestroId: String,
    val nombreArchivo: String,
    val tipoMime: String,
    val uriLocal: String? = null,
    val urlRemota: String? = null,
    val fechaCarga: String,
    val estadoCarga: EstadoCargaEvidencia = EstadoCargaEvidencia.PENDIENTE
)
