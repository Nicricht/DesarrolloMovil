package com.example.seguimientosiniestros.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "siniestros")
data class SiniestroEntity(
    @PrimaryKey
    val id: String,
    val tipo: String,
    val fechaOcurrencia: String,
    val fechaReporte: String,
    val estado: String,
    val equipoAsignado: String? = null,
    val ultimaActualizacion: String? = null
)
