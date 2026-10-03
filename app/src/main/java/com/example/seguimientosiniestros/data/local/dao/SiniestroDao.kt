package com.example.seguimientosiniestros.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.seguimientosiniestros.data.local.entity.SiniestroEntity

@Dao
interface SiniestroDao {

    @Upsert
    suspend fun guardar(siniestro: SiniestroEntity)

    @Query("SELECT * FROM siniestros WHERE id = :id LIMIT 1")
    suspend fun obtenerPorId(id: String): SiniestroEntity?
}
