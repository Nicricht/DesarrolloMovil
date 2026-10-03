package com.example.seguimientosiniestros.data.local

import com.example.seguimientosiniestros.data.local.dao.GestionHistorialDao
import com.example.seguimientosiniestros.data.local.dao.SiniestroDao
import com.example.seguimientosiniestros.data.local.entity.GestionHistorialEntity
import com.example.seguimientosiniestros.data.local.entity.SiniestroEntity

class LocalSiniestroDataSource(
    private val siniestroDao: SiniestroDao,
    private val gestionHistorialDao: GestionHistorialDao
) {
    suspend fun obtenerSiniestro(id: String): SiniestroEntity? =
        siniestroDao.obtenerPorId(id)

    suspend fun obtenerHistorial(siniestroId: String): List<GestionHistorialEntity> =
        gestionHistorialDao.obtenerPorSiniestro(siniestroId)

    suspend fun guardarSiniestro(siniestro: SiniestroEntity) {
        siniestroDao.guardar(siniestro)
    }

    suspend fun guardarHistorial(gestiones: List<GestionHistorialEntity>) {
        gestionHistorialDao.guardarTodos(gestiones)
    }
}
