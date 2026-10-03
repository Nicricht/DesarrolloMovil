package com.example.seguimientosiniestros.data.mapper

import com.example.seguimientosiniestros.data.local.entity.GestionHistorialEntity
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.domain.model.GestionHistorial

fun GestionHistorial.toEntity() = GestionHistorialEntity(
    id = id,
    siniestroId = siniestroId,
    fechaHora = fechaHora,
    descripcion = descripcion,
    estadoResultante = estadoResultante?.name
)

fun GestionHistorialEntity.toDomain() = GestionHistorial(
    id = id,
    siniestroId = siniestroId,
    fechaHora = fechaHora,
    descripcion = descripcion,
    estadoResultante = estadoResultante?.let(EstadoSiniestro::valueOf)
)
