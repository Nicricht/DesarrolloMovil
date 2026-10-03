package com.example.seguimientosiniestros.data.repository

import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.data.mapper.toDomain
import com.example.seguimientosiniestros.data.mapper.toEntity
import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository

class LocalSiniestroRepository(
    private val localDataSource: LocalSiniestroDataSource
) : SiniestroRepository {

    override suspend fun obtenerSiniestro(id: String): Siniestro? =
        localDataSource.obtenerSiniestro(id)?.toDomain()

    override suspend fun obtenerHistorial(siniestroId: String): List<GestionHistorial> =
        localDataSource.obtenerHistorial(siniestroId).map { it.toDomain() }

    override suspend fun guardarSiniestro(siniestro: Siniestro) {
        localDataSource.guardarSiniestro(siniestro.toEntity())
    }

    override suspend fun guardarHistorial(gestiones: List<GestionHistorial>) {
        localDataSource.guardarHistorial(gestiones.map { it.toEntity() })
    }
}
