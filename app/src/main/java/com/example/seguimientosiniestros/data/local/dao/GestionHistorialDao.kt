package com.example.seguimientosiniestros.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.seguimientosiniestros.data.local.entity.GestionHistorialEntity

@Dao
interface GestionHistorialDao {

    @Upsert
    suspend fun guardar(gestion: GestionHistorialEntity)

    @Upsert
    suspend fun guardarTodos(gestiones: List<GestionHistorialEntity>)

    @Query(
        "SELECT * FROM historial " +
            "WHERE siniestroId = :siniestroId " +
            "ORDER BY fechaHora DESC"
    )
    suspend fun obtenerPorSiniestro(siniestroId: String): List<GestionHistorialEntity>
}
