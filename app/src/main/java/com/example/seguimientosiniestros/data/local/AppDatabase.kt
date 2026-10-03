package com.example.seguimientosiniestros.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.seguimientosiniestros.data.local.dao.GestionHistorialDao
import com.example.seguimientosiniestros.data.local.dao.SiniestroDao
import com.example.seguimientosiniestros.data.local.entity.GestionHistorialEntity
import com.example.seguimientosiniestros.data.local.entity.SiniestroEntity

@Database(
    entities = [
        SiniestroEntity::class,
        GestionHistorialEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun siniestroDao(): SiniestroDao
    abstract fun gestionHistorialDao(): GestionHistorialDao

    companion object {
        private const val DATABASE_NAME = "seguimiento_siniestros.db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build().also { instance = it }
            }
    }
}
