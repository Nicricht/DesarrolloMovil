package com.example.seguimientosiniestros.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "historial",
    foreignKeys = [
        ForeignKey(
            entity = SiniestroEntity::class,
            parentColumns = ["id"],
            childColumns = ["siniestroId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["siniestroId"])]
)
data class GestionHistorialEntity(
    @PrimaryKey
    val id: String,
    val siniestroId: String,
    val fechaHora: String,
    val descripcion: String,
    val estadoResultante: String? = null
)
