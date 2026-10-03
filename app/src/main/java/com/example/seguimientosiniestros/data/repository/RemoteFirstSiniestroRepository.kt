package com.example.seguimientosiniestros.data.repository

import com.example.seguimientosiniestros.data.local.LocalSiniestroDataSource
import com.example.seguimientosiniestros.data.mapper.toDomain
import com.example.seguimientosiniestros.data.mapper.toEntity
import com.example.seguimientosiniestros.data.remote.RemoteSiniestroDataSource
import com.example.seguimientosiniestros.domain.model.GestionHistorial
import com.example.seguimientosiniestros.domain.model.Siniestro
import com.example.seguimientosiniestros.domain.repository.SiniestroRepository
import java.io.IOException
import retrofit2.HttpException

class RemoteFirstSiniestroRepository(
    private val remoteDataSource: RemoteSiniestroDataSource,
    private val localDataSource: LocalSiniestroDataSource
) : SiniestroRepository {

    override suspend fun obtenerSiniestro(id: String): Siniestro? =
        try {
            val remoto = remoteDataSource.obtenerSiniestro(id).toDomain()
            localDataSource.guardarSiniestro(remoto.toEntity())
            remoto
        } catch (error: HttpException) {
            if (error.code() == 404) {
                null
            } else {
                localDataSource.obtenerSiniestro(id)?.toDomain() ?: throw error
            }
        } catch (_: IOException) {
            localDataSource.obtenerSiniestro(id)?.toDomain()
        }

    override suspend fun obtenerHistorial(
        siniestroId: String
    ): List<GestionHistorial> =
        try {
            val remoto = remoteDataSource.obtenerHistorial(siniestroId)
                .map { it.toDomain(siniestroId) }

            localDataSource.guardarHistorial(remoto.map { it.toEntity() })
            remoto
        } catch (error: HttpException) {
            if (error.code() == 404) {
                emptyList()
            } else {
                val local = localDataSource.obtenerHistorial(siniestroId)
                    .map { it.toDomain() }

                if (local.isNotEmpty()) local else throw error
            }
        } catch (_: IOException) {
            localDataSource.obtenerHistorial(siniestroId)
                .map { it.toDomain() }
        }

    override suspend fun guardarSiniestro(siniestro: Siniestro) {
        localDataSource.guardarSiniestro(siniestro.toEntity())
    }

    override suspend fun guardarHistorial(gestiones: List<GestionHistorial>) {
        localDataSource.guardarHistorial(gestiones.map { it.toEntity() })
    }
}
