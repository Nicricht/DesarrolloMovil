package com.example.seguimientosiniestros.data.mapper

import com.example.seguimientosiniestros.data.remote.dto.GestionHistorialDto
import com.example.seguimientosiniestros.data.remote.dto.SiniestroDto
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro

fun SiniestroDto.toDomain() = Siniestro(
    id = id,
    tipo = tipo,
    fechaOcurrencia = fechaOcurrencia,
    fechaReporte = fechaReporte,
    estado = EstadoSiniestro.valueOf(estado),
    equipoAsignado = equipoAsignado,
    ultimaActualizacion = ultimaActualizacion
)

fun GestionHistorialDto.toDomain(siniestroId: String) = GestionHistorial(
    id = id,
    siniestroId = siniestroId,
    fechaHora = fechaHora,
    descripcion = descripcion,
    estadoResultante = estadoResultante?.let(EstadoSiniestro::valueOf)
)
