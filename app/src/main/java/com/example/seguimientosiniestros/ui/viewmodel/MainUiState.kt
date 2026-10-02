package com.example.seguimientosiniestros.ui.viewmodel

import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro

data class MainUiState(
    val cargando: Boolean = false,
    val siniestro: Siniestro? = null,
    val historial: List<GestionHistorial> = emptyList(),
    val mensajeError: String? = null
)
