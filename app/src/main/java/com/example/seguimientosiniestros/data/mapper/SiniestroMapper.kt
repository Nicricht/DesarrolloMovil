package com.example.seguimientosiniestros.data.mapper

import com.example.seguimientosiniestros.data.local.entity.SiniestroEntity
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.domain.model.Siniestro

fun Siniestro.toEntity() = SiniestroEntity(
    id = id,
    tipo = tipo,
    fechaOcurrencia = fechaOcurrencia,
    fechaReporte = fechaReporte,
    estado = estado.name,
    equipoAsignado = equipoAsignado,
    ultimaActualizacion = ultimaActualizacion
)

fun SiniestroEntity.toDomain() = Siniestro(
    id = id,
    tipo = tipo,
    fechaOcurrencia = fechaOcurrencia,
    fechaReporte = fechaReporte,
    estado = EstadoSiniestro.valueOf(estado),
    equipoAsignado = equipoAsignado,
    ultimaActualizacion = ultimaActualizacion
)
